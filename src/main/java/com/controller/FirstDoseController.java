package com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dto.UserModel;
import com.service.LocationService;
import com.service.UserService;
import com.service.VaccineService;

@RestController
@RequestMapping("/dose")
public class FirstDoseController {

	@Autowired
	VaccineService vaccineService;
	@Autowired
	UserService userService;
	@Autowired
	LocationService locationService;

	String firstDosePage = "firstdose";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@GetMapping("/one")
	public ModelAndView viewFirstDosePage() {
		ModelAndView modelAndView = new ModelAndView();
		UserModel model = userService.getUserModel();
		if (!model.isDoseOne()) {
			modelAndView.setViewName(firstDosePage);

		} else {
			modelAndView.addObject("name", model.getVaccineName());
			modelAndView.addObject("date", model.getFirstDoseDate());
			modelAndView.addObject("location", model.getFirstDoseVaccineLocation());
			modelAndView.addObject("msg", "Dose 1 already taken");
			modelAndView.setViewName("TakenDosePage");
		}
		return modelAndView;
	}

	@PostMapping("/one")
	public ModelAndView scheduleFirstDose(@RequestParam("vaccineName") String vaccineName,
			@RequestParam("vaccineLocation") String vaccineLocation,
			@RequestParam("firstDoseDate") String firstDoseDate) {

		ModelAndView modelAndView = new ModelAndView();

		UserModel model = userService.getUserModel();
		int opt = 1;
		if (vaccineName.equalsIgnoreCase("covishield")) {
			opt = 2;
		}

		if (locationService.checkLocation(vaccineLocation, opt)) {

			model.setDoseOne(true);
			model.setVaccineName(vaccineName);

			model.setFirstDoseVaccineLocation(vaccineLocation);
			LocalDate doseDate = LocalDate.parse(firstDoseDate, formatter);
			model.setFirstDoseDate(doseDate);

			locationService.updateFirstDoseDates(model);

			vaccineService.reduceVaccineCountAfterAppointment(vaccineLocation, vaccineName);

			modelAndView.addObject("msg", "dose 1 booked");
			modelAndView.addObject("vaccine", vaccineName);
			modelAndView.addObject("date", firstDoseDate);
			modelAndView.addObject("location", vaccineLocation);
			modelAndView.setViewName(firstDosePage);
		} else {
			modelAndView.addObject("vaccine", vaccineName);
			modelAndView.addObject("date", firstDoseDate);
			modelAndView.addObject("errormessage", "Sorry current selected location has no doses at present");
			modelAndView.setViewName(firstDosePage);
		}
		return modelAndView;
	}

	String updateFirstDosePage = "updateFirstDose";

	@GetMapping("/one/edit")
	public ModelAndView updateFirstDose() {
		ModelAndView modelAndView = new ModelAndView();
		UserModel model = userService.getUserModel();
		if (model.isDoseOne()) {
			modelAndView.setViewName(updateFirstDosePage);
		} else {
			modelAndView.addObject("errmsg", "Please Schedule your dose 1 before updating");
			modelAndView.setViewName("TakenDosePage");
		}
		return modelAndView;
	}

	@PostMapping("/one/edit")
	public ModelAndView updateFirstDoseDetails(@RequestParam("vaccineName") String vaccineName,
			@RequestParam("vaccineLocation") String vaccineLocation,
			@RequestParam("firstDoseDate") String firstDoseDate) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(updateFirstDosePage);
		UserModel model = userService.getUserModel();

		int opt = 1;
		if (vaccineName.equalsIgnoreCase("covishield")) {
			opt = 2;
		}

		if (locationService.checkLocation(vaccineLocation, opt)) {

			if (!model.getFirstDoseVaccineLocation().equals(vaccineLocation)) {
				vaccineService.reduceVaccineCountAfterAppointment(vaccineLocation, vaccineName);
				vaccineService.addVaccineCountAfterUpdating(model.getFirstDoseVaccineLocation(), vaccineName);
			}
			model.setVaccineName(vaccineName);
			LocalDate doseDate = LocalDate.parse(firstDoseDate, formatter);
			model.setFirstDoseDate(doseDate);
			model.setFirstDoseVaccineLocation(vaccineLocation);
			locationService.updateFirstDoseDates(model);

			modelAndView.addObject("updatemsg", "dose one details updated");
			modelAndView.setViewName(updateFirstDosePage);

		} else {
			modelAndView.addObject("vaccine", vaccineName);
			modelAndView.addObject("date", firstDoseDate);

			modelAndView.addObject("errormessage", "Sorry current selected location has no doses at present");
			modelAndView.setViewName(updateFirstDosePage);
		}

		return modelAndView;
	}

}
