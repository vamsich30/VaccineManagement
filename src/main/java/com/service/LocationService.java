package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.DAOConverter;
import com.dto.UserModel;
import com.repos.UserRepo;

@Service
public class LocationService {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");

	@Autowired
	VaccineService vaccineService;

	@Autowired
	UserRepo userRepo;

	public void updateFirstDoseDates(UserModel model) {
		userRepo.save(DAOConverter.userDtoToEntity(model));
	}

	public void updateSecondDoseDates(UserModel model) {

		userRepo.save(DAOConverter.userDtoToEntity(model));
	}

	public String calculateSecondDoseDate(String date) {
		LocalDate localDate = LocalDate.parse(date, formatter).plusDays(45);
		return formatter.format(localDate);
	}

	public boolean checkLocation(String location, int opt) {

		boolean result = false;
		if (opt == 1) {

			Map<String, Integer> covaxinDB = vaccineService.getVaccineDetails("Covaxin");
			Set<String> keys = covaxinDB.keySet();
			for (String key : keys) {
				if (key.equalsIgnoreCase((location.toUpperCase())) && covaxinDB.get(key) > 0) {
					result = true;
					break;
				}
			}

		}
		if (opt == 2) {
			Map<String, Integer> covishieldDB = vaccineService.getVaccineDetails("Covishield");
			Set<String> keys = covishieldDB.keySet();
			for (String key : keys) {
				if (key.equalsIgnoreCase((location.toUpperCase())) && covishieldDB.get(key) > 0) {
					result = true;
					break;
				}
			}

		}
		return result;
	}

	public long gapBetweenDoses(String firstDoseDate, String secondDoseDate) throws ParseException {
		long differenceInDays = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/d");
		Date d1 = sdf.parse(firstDoseDate);
		Date d2 = sdf.parse(secondDoseDate);

		long differenceInTime = d2.getTime() - d1.getTime();
		differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInTime) % 365;

		return differenceInDays;
	}
}
