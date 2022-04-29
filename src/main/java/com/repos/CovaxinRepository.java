package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.CovaxinEntity;

public interface CovaxinRepository extends JpaRepository<CovaxinEntity, String> {
	CovaxinEntity findByLocation(String location);
	
//	@Query(countQuery = "SELECT sum(vaccinecount) FROM covaxin")
//    public int getCovaxinCount();
}
