package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CovaxinDTO;
import com.service.AdminService;
import com.service.VaccineService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	VaccineService vaccineService;

	String adminPage = "adminLogin";

	@GetMapping
	public ModelAndView viewLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminLogin");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView login(@RequestParam("adminName") String adminName,
			@RequestParam("adminPassword") String password) {
		ModelAndView modelAndView = new ModelAndView();

		if (!adminName.isBlank() || !password.isBlank()) {
			if (adminService.adminLoginValidation(adminName, password)) {
				modelAndView.addObject("msg", "Login Successful");
				modelAndView.setViewName(adminPage);
			} else {
				modelAndView.addObject("msg", "Invalid login");
				modelAndView.setViewName(adminPage);

			}
		} else {
			modelAndView.addObject("errmsg", "Please Enter valid credentials");
			modelAndView.setViewName(adminPage);
		}

		return modelAndView;
	}

	@GetMapping("/centers")
	public ModelAndView viewDosePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminLogin");
		modelAndView.addObject("covaxinMap", vaccineService.getVaccineDetails("covaxin"));
		modelAndView.addObject("covishieldMap", vaccineService.getVaccineDetails("covishield"));
		modelAndView.setViewName("adminCenters");
		return modelAndView;
	}

	@GetMapping("/centers/edit/covaxin")
	public ModelAndView viewEditCovaxinCentersPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editCovaxinCenters");
		return modelAndView;
	}

	@PostMapping("/centers/edit/covaxin")
	public ModelAndView editCenters(@Valid @ModelAttribute("covaxinDto") CovaxinDTO covaxinDTO) {
		ModelAndView modelAndView = new ModelAndView();
		vaccineService.updateVaccineCenter(covaxinDTO.getLocation().toUpperCase(), covaxinDTO.getVaccineCount(),
				"Covaxin");
		modelAndView.addObject("msg", "Successfully Updated");
		modelAndView.setViewName("editCovaxinCenters");

		return modelAndView;
	}
}
