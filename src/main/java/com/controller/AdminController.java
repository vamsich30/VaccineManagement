package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.AdminModel;
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
	String editCovishiledCenters = "editCovishieldCenters";

	@GetMapping("/signup")
	public ModelAndView viewSignUpPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminSignUp");
		return modelAndView;
	}

	@PostMapping("/signup")
	public ModelAndView signUp(@RequestParam("adminName") String adminName,
			@RequestParam("adminPassword") String password) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminSignUp");
		if (!adminService.checkAdminExists(adminName)) {
			AdminModel adminModel = new AdminModel();
			adminModel.setAdminName(adminName);
			adminModel.setAdminPassword(password);
			adminService.saveAdmin(adminModel);
			modelAndView.setViewName(adminPage);
		} else {
			modelAndView.addObject("errmsg", "Admin Name already exists");
		}

		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView viewLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminLogin");
		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("adminName") String adminName,
			@RequestParam("adminPassword") String password) {
		ModelAndView modelAndView = new ModelAndView();

		if (adminService.adminLoginValidation(adminName, password)) {
			modelAndView.addObject("adminName", adminName);
			modelAndView.setViewName("adminhome");
		} else {
			modelAndView.addObject("errmsg", "Invalid login");
			modelAndView.setViewName(adminPage);

		}

		return modelAndView;
	}

//	@GetMapping("/centers")
//	public ModelAndView viewDosePage() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("adminLogin");
//		if (adminService.getAdminModel() != null) {
//			modelAndView.addObject("covaxinMap", vaccineService.getVaccineDetails("covaxin"));
//			modelAndView.addObject("covishieldMap", vaccineService.getVaccineDetails("covishield"));
//			modelAndView.setViewName("adminCenters");
//		}
//		return modelAndView;
//	}

	@GetMapping("/centers/edit/covaxin")
	public ModelAndView viewEditCovaxinCentersPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editCovaxinCenters");
		return modelAndView;
	}

	@PostMapping("/centers/edit/covaxin")
	public ModelAndView editCenters(@RequestParam("location") String location,
			@RequestParam("vaccineCount") int count) {
		ModelAndView modelAndView = new ModelAndView();
		vaccineService.updateVaccineCenter(location.toUpperCase(), count, "Covaxin");
		modelAndView.addObject("city", location);
		modelAndView.addObject("count", count);
		modelAndView.addObject("msg", "Successfully Updated");
		modelAndView.setViewName("editCovaxinCenters");

		return modelAndView;
	}

	@GetMapping("/centers/edit/covishield")
	public ModelAndView viewEditCoviShieldCentersPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(editCovishiledCenters);
		return modelAndView;
	}

	@PostMapping("/centers/edit/covishield")
	public ModelAndView editCoviShieldCenters(@RequestParam("location") String location,
			@RequestParam("vaccineCount") int count) {
		ModelAndView modelAndView = new ModelAndView();
		vaccineService.updateVaccineCenter(location.toUpperCase(), count, "Covishield");
		modelAndView.addObject("city", location);
		modelAndView.addObject("count", count);
		modelAndView.addObject("msg", "Successfully Updated");
		modelAndView.setViewName(editCovishiledCenters);
		return modelAndView;
	}

	@GetMapping("/users")
	public ModelAndView viewUsers() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", adminService.getUsers());
		modelAndView.setViewName("viewUsers");
		return modelAndView;
	}

	@GetMapping("/admin-dashboard")
	public ModelAndView viewAdminDashboard() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(adminPage);
		if (adminService.getAdminModel() != null) {
			modelAndView.addObject("adminName", adminService.getAdminModel().getAdminName());
			modelAndView.setViewName("adminhome");
		}
		return modelAndView;
	}

}
