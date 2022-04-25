package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.DAOConverter;
import com.dto.AdminModel;
import com.entity.AdminEntity;
import com.repos.AdminRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepo;

	private static AdminModel adminModel;

	public boolean adminLoginValidation(String adminName, String password) {
		boolean result = false;
		if (adminRepo.existsById(adminName)) {
			AdminEntity admin = adminRepo.findByAdminName(adminName);
			if (admin.getAdminPassword().equals(password)) {
				result = true;
				adminModel = DAOConverter.adminEntitytoDto(admin);
			}
		}

		return result;
	}

	public AdminModel getAdminModel() {
		return adminModel;
	}

	public void saveAdmin(AdminModel adminDto) {
		adminRepo.save(DAOConverter.adminDtoToEntity(adminDto));
	}

}
