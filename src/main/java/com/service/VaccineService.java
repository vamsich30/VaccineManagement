package com.service;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CovaxinEntity;
import com.entity.CoviShieldEntity;
import com.repos.CovaxinRepository;
import com.repos.CoviShieldRepository;

@Service
public class VaccineService {
	@Autowired
	CoviShieldRepository covishield;
	@Autowired
	CovaxinRepository covaxin;

	public Map<String, Integer> getVaccineDetails(String vaccineType) {
		Map<String, Integer> map = new TreeMap<>();
		if (vaccineType.equalsIgnoreCase("Covishield")) {
			Iterable<CoviShieldEntity> list = covishield.findAll();
			for (CoviShieldEntity center : list) {
				map.put(center.getLocation(), center.getVaccineCount());
			}
		} else if (vaccineType.equalsIgnoreCase("Covaxin")) {
			Iterable<CovaxinEntity> list = covaxin.findAll();
			for (CovaxinEntity center : list) {
				map.put(center.getLocation(), center.getVaccineCount());
			}
		}
		return map;
	}

	public void reduceVaccineCountAfterAppointment(String vaccineLocation, String vaccineName) {

		if (vaccineName.equalsIgnoreCase("covaxin")) {
			CovaxinEntity vaccineCenter = covaxin.findByLocation(vaccineLocation);
			vaccineCenter.setVaccineCount(vaccineCenter.getVaccineCount() - 1);
			covaxin.save(vaccineCenter);
		} else {
			CoviShieldEntity vaccineCenter = covishield.findByLocation(vaccineLocation);
			vaccineCenter.setVaccineCount(vaccineCenter.getVaccineCount() - 1);
			covishield.save(vaccineCenter);
		}
	}

	public void addVaccineCountAfterUpdating(String vaccineLocation, String vaccineName) {
		if (vaccineName.equalsIgnoreCase("covaxin")) {
			CovaxinEntity vaccineCenter = covaxin.findByLocation(vaccineLocation);
			vaccineCenter.setVaccineCount(vaccineCenter.getVaccineCount() + 1);
			covaxin.save(vaccineCenter);
		} else {
			CoviShieldEntity vaccineCenter = covishield.findByLocation(vaccineLocation);
			vaccineCenter.setVaccineCount(vaccineCenter.getVaccineCount() + 1);
			covishield.save(vaccineCenter);
		}
	}

	public void updateVaccineCenter(String vaccineLocation, int count, String vaccine) {
		if (vaccine.equalsIgnoreCase("covaxin")) {
			CovaxinEntity entity = covaxin.getById(vaccineLocation);
			entity.setVaccineCount(count);
			covaxin.save(entity);
		} else {
			CoviShieldEntity entity = new CoviShieldEntity();
			entity.setLocation(vaccineLocation);
			entity.setVaccineCount(count);
			covishield.save(entity);
		}
	}

}
