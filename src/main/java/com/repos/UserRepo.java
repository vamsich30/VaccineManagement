package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserModelEntity;

public interface UserRepo extends JpaRepository<UserModelEntity, String> {
	UserModelEntity findByAadharNumber(String aadharNumber);
	boolean existsByMobileNumber(String number);
}
