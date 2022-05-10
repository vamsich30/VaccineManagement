package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dto.AdminModel;
import com.entity.AdminEntity;
import com.entity.UserModelEntity;
import com.repos.AdminRepo;
import com.repos.CovaxinRepository;
import com.repos.CoviShieldRepository;
import com.repos.UserRepo;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

	@InjectMocks
	AdminService adminService;
	@Mock
	AdminRepo adminRepo;
	@Mock
	UserRepo userRepo;
	@Mock
	CovaxinRepository covaxinRepository;
	@Mock
	CoviShieldRepository coviShieldRepository;

	AdminEntity adminEntity;

	@BeforeEach
	void setup() {
		adminEntity = new AdminEntity();
		adminEntity.setAdminName("admin");
		adminEntity.setAdminPassword("admin");
	}

	@Test
	void testValidAdminLogin() {
		when(adminRepo.existsById(anyString())).thenReturn(true);
		when(adminRepo.findByAdminName(anyString())).thenReturn(adminEntity);
		assertTrue(adminService.adminLoginValidation("admin", "admin"));
	}

	@Test
	void testAdminNotPresentLogin() {
		when(adminRepo.existsById(anyString())).thenReturn(false);
		assertFalse(adminService.adminLoginValidation("admin", "admin"));
	}

	@Test
	void testAdminInvalidLoginPassword() {
		when(adminRepo.existsById(anyString())).thenReturn(true);
		when(adminRepo.findByAdminName(anyString())).thenReturn(adminEntity);
		assertFalse(adminService.adminLoginValidation("admin", "adminPass"));
	}

	@Test
	void testSaveAdminDetails() {
		AdminModel adminModel = new AdminModel();
		adminService.saveAdmin(adminModel);
		verify(adminRepo).save(any());
	}

	@Test
	void testUsersCount() {
		when(userRepo.count()).thenReturn(100L);
		assertEquals(100L, adminService.usersCount());
	}

	@Test
	void testCheckAdminExists() {
		when(adminRepo.existsById(anyString())).thenReturn(true);
		assertTrue(adminService.checkAdminExists("admin"));
	}

	@Test
	void testCheckAdminDoesNotExist() {
		when(adminRepo.existsById(anyString())).thenReturn(false);
		assertFalse(adminService.checkAdminExists("admin"));
	}

	@Test
	void testAdminModel() {
		when(adminRepo.existsById(anyString())).thenReturn(true);
		when(adminRepo.findByAdminName(anyString())).thenReturn(adminEntity);
		assertEquals(true, adminService.adminLoginValidation("admin", "admin"));
		AdminModel model = adminService.getAdminModel();
		assertEquals(model.getAdminName(), adminEntity.getAdminName());

	}

	@Test
	void testGetListOfUsers() {
		UserModelEntity userModelEntity = new UserModelEntity();
		userModelEntity.setAadharNumber("123456789111");
		List<UserModelEntity> list = new ArrayList<>();
		list.add(userModelEntity);
		when(userRepo.findAll()).thenReturn(list);
		assertEquals(1, adminService.getUsers().size());
	}

}
