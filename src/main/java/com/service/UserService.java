package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.DAOConverter;
import com.dto.UserModel;
import com.entity.UserModelEntity;
import com.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	private static UserModel userDTO;

	public boolean checkAadharInDatabase(String aadharNumber) {
		return userRepo.existsById(aadharNumber);
	}

	public boolean checkMobileNumberInDatabase(String number) {
		return userRepo.existsByMobileNumber(number);
	}

	public void saveUser(UserModel model) {
		userRepo.save(DAOConverter.userDtoToEntity(model));
	}

	public boolean checkPassword(String aadharNumber, String password) {
		boolean res = false;
		if (checkAadharInDatabase(aadharNumber)) {
			UserModelEntity entity = userRepo.findByAadharNumber(aadharNumber);
			res = entity.getPassword().equals(password);
		}
		return res;
	}

	public boolean loginValidation(String aadharNumber, String password) {
		boolean status = checkAadharInDatabase(aadharNumber) && checkPassword(aadharNumber, password);
		if (status) {
			userDTO = DAOConverter.userEntityToDto(userRepo.findByAadharNumber(aadharNumber));
		}
		return status;
	}

	public UserModel getUserModel() {
		return userDTO;
	}

	public void Reset() {
		userDTO = null;
	}

}
