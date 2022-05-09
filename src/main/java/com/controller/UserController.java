package com.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

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
		if (result.getFieldErrorCount("username") != 0 || result.getFieldErrorCount("aadharNumber") != 0
				|| result.getFieldErrorCount("password") != 0 || result.getFieldErrorCount("age") != 0
				|| result.getFieldErrorCount("mobileNumber") != 0) {

			Map<String, Object> map = new HashMap<>();
			map.put("username", model.getUsername());
			map.put("aadharNumber", model.getAadharNumber());
			map.put("age", model.getAge());
			map.put("mobileNumber", model.getMobileNumber());
			map.put("message", "Please enter valid details");
			modelAndView.addAllObjects(map);
			modelAndView.setViewName(signUpPage);

		} else {

			boolean phnRes = true;
			boolean aadharRes = true;

			if (service.checkMobileNumberInDatabase(model.getMobileNumber())) {
				Map<String, Object> map = new HashMap<>();
				map.put("username", model.getUsername());
				map.put("aadharNumber", model.getAadharNumber());
				map.put("age", model.getAge());
				map.put("mobileNumber", model.getMobileNumber());
				map.put("phnmsg", "Mobile Number already Exists");
				modelAndView.addAllObjects(map);
				modelAndView.setViewName(signUpPage);
				phnRes = false;
			}
			if (service.checkAadharInDatabase(model.getAadharNumber())) {
				aadharRes = false;
				Map<String, Object> map = new HashMap<>();
				map.put("username", model.getUsername());
				map.put("age", model.getAge());
				map.put("mobileNumber", model.getMobileNumber());
				modelAndView.addObject("errormessage", "Aadhaar Number already Exists");
				modelAndView.addAllObjects(map);
				modelAndView.setViewName(signUpPage);
			}
			if (phnRes && aadharRes) {
				service.saveUser(model);
				modelAndView.setViewName("login");
			}
		}
		return modelAndView;
	}

	@PostMapping("/signin")
	public ModelAndView checkLoginDetails(@Valid @ModelAttribute("userModel") UserModel model, BindingResult result)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
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
