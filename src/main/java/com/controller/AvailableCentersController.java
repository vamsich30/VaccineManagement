package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.VaccineService;

@Controller
@RequestMapping("/centers")
public class AvailableCentersController {

	@Autowired
	VaccineService vaccineService;

	@GetMapping
	public ModelAndView loadCenters() {
		ModelAndView modelAndView = new ModelAndView();

		Map<String, Integer> covaxinDB = vaccineService.getVaccineDetails("Covaxin");
		Map<String, Integer> covishieldDB = vaccineService.getVaccineDetails("Covishield");

		modelAndView.addObject("covaxinMap", covaxinDB);
		modelAndView.addObject("covishieldMap", covishieldDB);
		modelAndView.setViewName("centers");
		return modelAndView;
	}

}
