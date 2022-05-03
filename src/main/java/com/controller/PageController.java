package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.service.UserService;

@RestController
public class PageController {

	@Autowired
	UserService userService;

	@GetMapping("/logout")
	public ModelAndView viewHomePageAfterLogout() {
		userService.Reset();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Home");
		return modelAndView;
	}

	@GetMapping("/home")
	public ModelAndView viewLoginMenuPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Home");
		return modelAndView;
	}

	@GetMapping("/dashboard")
	public ModelAndView viewHomePageAfterLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginmenu");
		return modelAndView;
	}

}
