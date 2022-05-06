package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Person;
import com.service.Detect;

@Controller
@RequestMapping("/")
public class HealthCheckUp {

	@Autowired
	Detect detect;

	@GetMapping("/check")
	public ModelAndView viewCheckUpPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("checkup");
		return modelAndView;
	}

	@PostMapping("/check")
	public ModelAndView checkUp(@ModelAttribute("person") Person person) {
		ModelAndView modelAndView = new ModelAndView();
		String res = detect.detectCorona(person);
		modelAndView.addObject("userName", person.getUserName());
		modelAndView.addObject("age", person.getAge());
		modelAndView.addObject("feverDegree", person.getFeverDegree());
		modelAndView.addObject("msg", res);
		modelAndView.setViewName("checkup");
		return modelAndView;
	}

}
