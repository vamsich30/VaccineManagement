package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dto.UserModel;
import com.repos.UserRepo;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

	@InjectMocks
	LocationService locationService;
	@Mock
	VaccineService vaccineService;
	@Mock
	UserRepo userRepo;

	String date = "";

	@Test
	void testUpdateFirstDoseDates() {
		UserModel model = new UserModel();
		locationService.updateFirstDoseDates(model);
		verify(userRepo).save(any());
	}

	@Test
	void testUpdateSecondDoseDates() {
		UserModel model = new UserModel();
		locationService.updateSecondDoseDates(model);
		verify(userRepo).save(any());
	}

	@Test
	void CalculateSecondDoseDate() {
		date = "2022/03/30";
		assertEquals("2022/05/14", locationService.calculateSecondDoseDate(date));
	}

	@Test
	void testWithIncorrectSecondDoseDate() {
		date = "2022/03/30";
		assertNotEquals("2022/05/12", locationService.calculateSecondDoseDate(date));

	}

	@Test
	void testWithValidGapBetweenDoses() throws ParseException {
		String date1 = "2022/03/30";
		String date2 = "2022/05/14";
		assertEquals(45, locationService.gapBetweenDoses(date1, date2));
	}

	@Test
	void testWithInvalidGapBetweenDoses() throws ParseException {
		String date1 = "12/02/2022";
		String date2 = "25/03/2022";
		assertNotEquals(45, locationService.gapBetweenDoses(date1, date2));
	}

	@Test
	void testWithValidCovaxinLocation() {
		String location = "guntur";
		int opt = 1;
		Map<String, Integer> map = new HashMap<>();
		map.put(location, 23);

		when(vaccineService.getVaccineDetails(anyString())).thenReturn(map);
		// locationService.checkLocation(anyString(), opt);

		assertTrue(locationService.checkLocation(location, opt));

	}

	@Test
	void testWithValidCovishieldLocation() {
		String location = "guntur";
		int opt = 2;
		Map<String, Integer> map = new HashMap<>();
		map.put(location, 23);

		when(vaccineService.getVaccineDetails(anyString())).thenReturn(map);
		// locationService.checkLocation(anyString(), opt);

		assertTrue(locationService.checkLocation(location, opt));

	}

	@Test
	void testWithValidCovaxinLocationAndNoVaccinesInLocation() {

		String location = "guntur";
		int opt = 1;
		Map<String, Integer> map = new HashMap<>();
		map.put(location, 0);

		when(vaccineService.getVaccineDetails(anyString())).thenReturn(map);
		// locationService.checkLocation(anyString(), opt);

		assertEquals(false, locationService.checkLocation(location, opt));
	}

	@Test
	void testWithValidCovishieldLocationAndNoVaccinesInLocation() {

		String location = "guntur";
		int opt = 2;
		Map<String, Integer> map = new HashMap<>();
		map.put(location, 0);

		when(vaccineService.getVaccineDetails(anyString())).thenReturn(map);
		// locationService.checkLocation(anyString(), opt);

		assertEquals(false, locationService.checkLocation(location, opt));
	}

	@Test
	void testWithIncorrectLocation() {
		String location = "indore";
		int opt = 2;

		assertFalse(locationService.checkLocation(location, opt));
	}

	@Test
	void testWithInvalidOption() {
		String location = "vizag";
		int opt = 4;
		assertFalse(locationService.checkLocation(location, opt));
	}

	@Test
	void testWithLocation() {
		String location = "VIZAG";
		int opt = 2;
		assertFalse(locationService.checkLocation(location, opt));
	}

}
