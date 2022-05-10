package com.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dto.UserModel;
import com.entity.UserModelEntity;
import com.repos.UserRepo;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@InjectMocks
	UserService userService;

	@Mock
	UserRepo userRepo;

	UserModelEntity userModelEntity;

	@BeforeEach
	void setup() {
		userModelEntity = new UserModelEntity();
		userModelEntity.setAadharNumber("123456789011");
		userModelEntity.setPassword("pass");
	}

	@Test
	void testCheckAadharInDB() {
		when(userRepo.existsById(anyString())).thenReturn(true);
		assertTrue(userService.checkAadharInDatabase("123456789111"));
	}

	@Test
	void testInvalidCheckAadharInDB() {
		when(userRepo.existsById(anyString())).thenReturn(false);
		assertFalse(userService.checkAadharInDatabase("123456789111"));
	}

	@Test
	void testInvalidCheckAadharInDBWithInvalidChars() {
		when(userRepo.existsById(anyString())).thenReturn(false);
		assertFalse(userService.checkAadharInDatabase("skteftwgkyfferwui"));
	}

	@Test
	void testCheckMobileInDB() {
		when(userRepo.existsByMobileNumber(anyString())).thenReturn(true);
		assertTrue(userService.checkMobileNumberInDatabase("1234567890"));
	}

	@Test
	void testInvalidMobileInDB() {
		when(userRepo.existsByMobileNumber(anyString())).thenReturn(false);
		assertFalse(userService.checkMobileNumberInDatabase("1234567890"));
	}

	@Test
	void testInvalidMobileInDBInvalidChars() {
		when(userRepo.existsByMobileNumber(anyString())).thenReturn(false);
		assertFalse(userService.checkMobileNumberInDatabase("123456789utgwufg2h0"));
	}

	@Test
	void testSaveUser() {
		UserModel model = new UserModel();
		userService.saveUser(model);
		verify(userRepo).save(any());
	}

	@Test
	void testCheckPassword() {
		when(userService.checkAadharInDatabase(anyString())).thenReturn(true);
		when(userRepo.findByAadharNumber(anyString())).thenReturn(userModelEntity);
		assertTrue(userService.checkPassword("123456789011", "pass"));
	}

	@Test
	void testInvalidCheckPassword() {
		when(userService.checkAadharInDatabase(anyString())).thenReturn(false);
		assertFalse(userService.checkPassword("123456789001", "password"));
	}

//	@Test
//	void testGetModel() {
//		when(userRepo.findByAadharNumber(anyString())).thenReturn(userModelEntity);
//		when(userService.checkAadharInDatabase(anyString())).thenReturn(true);
//		when(userService.checkPassword(anyString(), anyString())).thenReturn(true);
//		userService.loginValidation("123456789011","pass");
//		assertEquals(userService.getUserModel().getAadharNumber(), userModelEntity.getAadharNumber());
//	}

}
