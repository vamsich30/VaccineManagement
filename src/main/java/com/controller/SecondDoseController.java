package com.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.UserModel;
import com.service.LocationService;
import com.service.UserService;
import com.service.VaccineService;

@Controller
@RequestMapping("/dose")
public class SecondDoseController {

	@Autowired
	UserService userService;
	@Autowired
	LocationService locationService;
	@Autowired
	VaccineService vaccineService;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	String secondDose = "seconddose";
	String takenDosePage = "TakenDosePage";
	String updateSecondDose = "updateSecondDose";

	@GetMapping("/two")
	public ModelAndView viewSecondDosePage() {
		ModelAndView modelAndView = new ModelAndView();
		UserModel model = userService.getUserModel();
		if (model.isDoseOne() && model.isDoseTwo()) {

			modelAndView.addObject("name", model.getVaccineName());
			modelAndView.addObject("date", model.getSecondDoseDate());
			modelAndView.addObject("location", model.getSecondDoseVaccineLocation());

			modelAndView.addObject("msg", "dose 2 already taken");
			modelAndView.setViewName("TakenDosePage");

		} else if (model.isDoseOne() && !model.isDoseTwo()) {
			modelAndView.addObject("vaccineName", model.getVaccineName());
			modelAndView.setViewName(secondDose);
		} else {
			modelAndView.addObject("errmsg", "Please be vaccinated for dose 1");
			modelAndView.setViewName(takenDosePage);
		}
		return modelAndView;
	}

	@GetMapping("/two/edit")
	public ModelAndView updateSecondDose() {
		ModelAndView modelAndView = new ModelAndView();
		UserModel model = userService.getUserModel();
		if (model != null) {
			if (!model.isDoseOne()) {
				modelAndView.addObject("errmsg", "Please be vaccinated for dose 1");
				modelAndView.setViewName(takenDosePage);
			} else {
				modelAndView.addObject("vaccineName", model.getVaccineName());
				modelAndView.addObject("doseDate", model.getSecondDoseDate());
				modelAndView.addObject("location", model.getSecondDoseVaccineLocation());
				modelAndView.setViewName(updateSecondDose);
			}
		} else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	String errorMessage = "errormessage";

	@PostMapping("/two")
	public ModelAndView scheduleSecondDose(@RequestParam("vaccineLocation") String vaccineLocation,
			@RequestParam("secondDoseDate") String secondDoseDate) throws ParseException {

		ModelAndView modelAndView = new ModelAndView();

		UserModel model = userService.getUserModel();

		String firstDoseDate = model.getFirstDoseDate().toString().replace("-", "/");
		secondDoseDate = secondDoseDate.replace("-", "/");
		int opt = 1;
		if (model.getVaccineName().equalsIgnoreCase("covishield")) {
			opt = 2;
		}

		if (locationService.checkLocation(vaccineLocation, opt)) {
			if (locationService.gapBetweenDoses(firstDoseDate, secondDoseDate) >= 45) {
				model.setDoseTwo(true);
				model.setSecondDoseVaccineLocation(vaccineLocation);
				LocalDate doseDate = LocalDate.parse(secondDoseDate.replace("/", "-"), formatter);
				model.setSecondDoseDate(doseDate);

				locationService.updateSecondDoseDates(model);

				vaccineService.reduceVaccineCountAfterAppointment(vaccineLocation, model.getVaccineName());

				modelAndView.addObject("msg", "dose 2 booked successfully");
				modelAndView.setViewName(secondDose);
			} else {
				modelAndView.addObject("vaccineName", model.getVaccineName());
				modelAndView.addObject("date", secondDoseDate);
				modelAndView.addObject("location", vaccineLocation);

				modelAndView.addObject("message",
						"Gap between first dose and second dose should be greater than 45 days");
				modelAndView.setViewName(secondDose);
			}
		} else {
			modelAndView.addObject("vaccineName", model.getVaccineName());
			modelAndView.addObject("date", secondDoseDate);
			modelAndView.addObject("message", "Sorry current location has no vaccines at present");
			modelAndView.setViewName(secondDose);
		}
		return modelAndView;
	}

	@PostMapping("/two/edit")
	public ModelAndView updateSecondDoseDetails(@RequestParam("vaccineLocation") String vaccineLocation,
			@RequestParam("secondDoseDate") String secondDoseDate) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		UserModel model = userService.getUserModel();
		if (model != null) {
			if (model.isDoseTwo()) {
				int opt = 1;
				String vaccineName = model.getVaccineName();
				if (vaccineName.equalsIgnoreCase("covishield")) {
					opt = 2;
				}
				String firstDoseDate = model.getFirstDoseDate().toString().replace("-", "/");
				secondDoseDate = secondDoseDate.replace("-", "/");
				if (locationService.checkLocation(vaccineLocation, opt)) {
					if (locationService.gapBetweenDoses(firstDoseDate, secondDoseDate) >= 45) {

						LocalDate doseDate = LocalDate.parse(secondDoseDate.replace("/", "-"), formatter);
						model.setSecondDoseDate(doseDate);

						if (!model.getSecondDoseVaccineLocation().equals(vaccineLocation)) {
							vaccineService.reduceVaccineCountAfterAppointment(vaccineLocation, vaccineName);
							vaccineService.addVaccineCountAfterUpdating(model.getSecondDoseVaccineLocation(),
									vaccineName);
						}
						model.setSecondDoseVaccineLocation(vaccineLocation);
						locationService.updateSecondDoseDates(model);
						modelAndView.addObject("vaccineName", model.getVaccineName());
						modelAndView.addObject("doseDate", model.getSecondDoseDate());
						modelAndView.addObject("location", model.getSecondDoseVaccineLocation());
						modelAndView.addObject("updatemsg", "dose 2 details updated");
						modelAndView.setViewName(updateSecondDose);
					} else {
						modelAndView.addObject("location", vaccineLocation);
						modelAndView.addObject(errorMessage, "Gap between doses should be greater than 45 days");
						modelAndView.setViewName(updateSecondDose);
					}
				} else {
					modelAndView.addObject("vaccineName", model.getVaccineName());
					modelAndView.addObject(errorMessage, "Sorry current selected location has no doses at present.");
					modelAndView.setViewName(updateSecondDose);
				}
			} else {
				modelAndView.addObject("errmsg", "Please Schedule your dose 2 before updating");
				modelAndView.setViewName(takenDosePage);
			}
		} else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

}
