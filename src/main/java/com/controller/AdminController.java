package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.AdminModel;
import com.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	String adminPage = "admin";

	@GetMapping("/login")
	public ModelAndView viewLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(adminPage);
		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login(@Valid @ModelAttribute("adminDto") AdminModel adminDto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();

		if (!result.hasErrors()) {
			if (adminService.adminLoginValidation(adminDto.getAdminName(), adminDto.getAdminPassword())) {
				modelAndView.addObject("msg", "Login Successful");
				modelAndView.setViewName(adminPage);
			} else {
				modelAndView.addObject("msg", "Invalid login");
				modelAndView.setViewName(adminPage);

			}
		} else {

			modelAndView.addObject("msg", "Please Enter valid credentials");
			modelAndView.setViewName(adminPage);

		}

		return modelAndView;

	}
}
