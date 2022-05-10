package com.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.repos.CovaxinRepository;
import com.repos.CoviShieldRepository;
@ExtendWith(MockitoExtension.class)
class VaccineServiceTest {

	@InjectMocks
	VaccineService vaccineService;
	
	@Mock
	CovaxinRepository covaxinRepository;
	@Mock
	CoviShieldRepository coviShieldRepository;
	

}
