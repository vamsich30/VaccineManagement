package com.service;

import java.util.Optional;

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

	static UserModel userDTO;

	public boolean userNameValidation(String userName) {
		return (!userName.matches("[a-zA-Z]+"));
	}

	public boolean userPasswordValidation(String password) {
		return password.isBlank();
	}

	public boolean userAgeValidation(String age) {
		boolean flag = false;
		if (Integer.parseInt(age) < 1 || age.matches("[a-zA-Z]+")) {
			flag = true;
		}
		return flag;
	}

	public boolean userAadharValidation(String aadharNumber) {
		return ((Optional.ofNullable(aadharNumber).isPresent() && aadharNumber.length() != 12)
				|| !(aadharNumber.matches("[0-9]+")));
	}

	public boolean checkAadharInDatabase(String aadharNumber) {
		boolean result = false;
		Optional<UserModelEntity> obj = userRepo.findById(aadharNumber);
		if (obj.isPresent()) {
			result = true;
		}
		return result;
	}

	public void register(UserModel model) {
		userRepo.save(DAOConverter.userDtoToEntity(model));
	}

	public boolean checkAadhar(String aadharNumber) {
		UserModelEntity entity = userRepo.findByAadharNumber(aadharNumber);
		return entity.getAadharNumber().equals(aadharNumber);

	}

	public boolean checkPassword(String aadharNumber, String password) {
		UserModelEntity entity = userRepo.findByAadharNumber(aadharNumber);
		return entity.getPassword().equals(password);
	}

	public boolean loginValidation(String aadharNumber, String password) {
		boolean status = false;
		try {
			status = checkAadhar(aadharNumber) && checkPassword(aadharNumber, password);
			userDTO = DAOConverter.userEntityToDto(userRepo.findByAadharNumber(aadharNumber));

		} catch (NullPointerException e) {
			status = false;
		}

		return status;
	}

	public UserModel getUserModel() {
		return userDTO;
	}

}
