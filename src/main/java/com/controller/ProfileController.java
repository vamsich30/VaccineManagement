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

	String editAdminPage = "editAdmin";
	String editUserPage = "editUser";
	String username = "username";
	String aadharNumber = "aadharNumber";

	@GetMapping("/admin")
	public ModelAndView viewAdminProfile() {
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

	@GetMapping("/admin/edit")
	public ModelAndView updateAdmin() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("adminName", adminService.getAdminModel().getAdminName());
		modelAndView.setViewName(editAdminPage);
		return modelAndView;
	}

	@GetMapping("/user/edit")
	public ModelAndView updateUser() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(username, userService.getUserModel().getUsername());
		modelAndView.addObject(aadharNumber, userService.getUserModel().getAadharNumber());
		modelAndView.addObject("age", userService.getUserModel().getAge());
		modelAndView.setViewName(editUserPage);
		return modelAndView;
	}

	@PostMapping("/admin/edit")
	public ModelAndView updateAdminPage(@Valid @ModelAttribute("adminModel") AdminModel adminDto,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("adminName", adminService.getAdminModel().getAdminName());
		AdminModel adminModel = new AdminModel();
		adminModel.setAdminName(adminService.getAdminModel().getAdminName());
		adminModel.setAdminPassword(adminDto.getAdminPassword());
		if (result.getFieldErrorCount("adminPassword") == 0) {
			if (adminDto.getAdminPassword().equals(adminService.getAdminModel().getAdminPassword())) {
				modelAndView.addObject("msg", "Password same as previous one try entering new password");
				modelAndView.setViewName(editAdminPage);

			} else {
				adminService.saveAdmin(adminModel);
				modelAndView.addObject("msg", "Profile updated successfully");
				modelAndView.setViewName(editAdminPage);
			}
		} else {
			modelAndView.addObject("msg", "Enter valid details");
			modelAndView.setViewName(editAdminPage);
		}
		return modelAndView;
	}

	@PostMapping("/user/edit")
	public ModelAndView updateUserDetails(@Valid @ModelAttribute UserModel model, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		UserModel existingUserModel = userService.getUserModel();

		if (result.getFieldErrorCount("username") == 0 && result.getFieldErrorCount("password") == 0
				&& result.getFieldErrorCount("age") == 0) {
			existingUserModel.setUsername(model.getUsername());
			existingUserModel.setPassword(model.getPassword());
			existingUserModel.setAge(model.getAge());

			userService.saveUser(existingUserModel);

			modelAndView.addObject(aadharNumber, existingUserModel.getAadharNumber());
			modelAndView.addObject(username, existingUserModel.getUsername());
			modelAndView.addObject("age", existingUserModel.getAge());

			modelAndView.addObject("successmessage", "Details Updated Successfully");
			modelAndView.setViewName(editUserPage);
		} else {
			modelAndView.addObject("errormessage", "Please enter valid credentials");
			modelAndView.addObject(aadharNumber, existingUserModel.getAadharNumber());
			modelAndView.addObject(username, existingUserModel.getUsername());
			modelAndView.addObject("age", existingUserModel.getAge());

			modelAndView.setViewName(editUserPage);
		}
		return modelAndView;
	}
}
