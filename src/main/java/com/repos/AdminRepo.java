package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, String> {
	
	AdminEntity findByAdminName(String adminName);
}
