package com.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.UserModel;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	String signUpPage = "registration";

	@GetMapping("/signup")
	public ModelAndView loadSignUpPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(signUpPage);
		return modelAndView;
	}

	@GetMapping("/signin")
	public ModelAndView loadLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@PostMapping("/signup")
	public ModelAndView register(@Valid @ModelAttribute("userModel") UserModel model, BindingResult result)
			throws NoSuchAlgorithmException, InvalidKeySpecException

	{
		ModelAndView modelAndView = new ModelAndView();
		if (result.getFieldErrorCount("username") != 0 && result.getFieldErrorCount("aadharNumber") != 0
				&& result.getFieldErrorCount("password") != 0 && result.getFieldErrorCount("age") != 0) {

			modelAndView.addObject("message", "Please enter valid data");
			modelAndView.setViewName(signUpPage);

		} else {
			if (!service.checkAadharInDatabase(model.getAadharNumber())) {
				service.register(model);
				modelAndView.addObject("successmessage", "Registration Successful");
				modelAndView.setViewName("success");
			} else {
				modelAndView.addObject("username", model.getUsername());
				modelAndView.addObject("password", model.getPassword());
				modelAndView.addObject("age", model.getAge());
				modelAndView.addObject("errormessage", "Aadhaar Number already Exists");
				modelAndView.setViewName(signUpPage);
			}
		}
		return modelAndView;
	}

	@PostMapping("/signin")
	public ModelAndView checkLoginDetails(@Valid @ModelAttribute("userModel") UserModel model, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();

		if (result.getFieldErrorCount("aadharNumber") == 0 && result.getFieldErrorCount("password") == 0) {
			if (service.loginValidation(model.getAadharNumber(), model.getPassword())) {
				modelAndView.setViewName("loginmenu");
			} else {
				modelAndView.addObject("errormessage", "Please enter valid credentials");
				modelAndView.setViewName("login");
			}
		}
		return modelAndView;
	}

}
