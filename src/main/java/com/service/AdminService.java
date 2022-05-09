package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.DAOConverter;
import com.dto.AdminModel;
import com.dto.UserModel;
import com.entity.AdminEntity;
import com.entity.UserModelEntity;
import com.repos.AdminRepo;
import com.repos.CovaxinRepository;
import com.repos.CoviShieldRepository;
import com.repos.UserRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	CovaxinRepository covaxinRepository;
	@Autowired
	CoviShieldRepository coviShieldRepository;

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

//	public int covaxinCount() {
//		return covaxinRepository.getCovaxinCount();
//	}

	public long usersCount() {
		return userRepo.count();
	}

	public boolean checkAdminExists(String adminName) {
		return (adminRepo.existsById(adminName));
	}

	public List<UserModel> getUsers() {
		Iterable<UserModelEntity> users = userRepo.findAll();
		List<UserModelEntity> userList = new ArrayList<>();
		users.forEach(userList::add);
		return toDtoList(userList);
	}

	public List<UserModel> toDtoList(List<UserModelEntity> list) {
		ModelMapper mapper = new ModelMapper();
		return list.stream().map(userModelEntity -> mapper.map(userModelEntity, UserModel.class))
				.collect(Collectors.toList());

	}

}
