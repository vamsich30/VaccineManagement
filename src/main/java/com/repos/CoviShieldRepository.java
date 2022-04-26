package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CoviShieldEntity;

@Repository
public interface CoviShieldRepository extends JpaRepository<CoviShieldEntity, String> {
	CoviShieldEntity findByLocation(String location);
}
