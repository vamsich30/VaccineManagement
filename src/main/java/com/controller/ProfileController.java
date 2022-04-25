package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.UserModel;
import com.service.AdminService;
import com.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AdminService adminService;

	@GetMapping("/admin")
	public ModelAndView viewAdminProfile()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("model", adminService.getAdminModel());
		modelAndView.setViewName("adminProfile");
		return modelAndView;
	}
	@GetMapping("/user")
	public ModelAndView displayUserProfile() {
		ModelAndView modelAndView = new ModelAndView();
		UserModel model = userService.getUserModel();
		modelAndView.addObject("model", model);

		modelAndView.setViewName("userProfile");
		return modelAndView;
	}
}
