package com.service;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserModel;
import com.entity.CovaxinEntity;
import com.entity.CoviShieldEntity;
import com.repos.CovaxinRepository;
import com.repos.CoviShieldRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

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

	public void sendFirstDoseConfirmationMessage(String doseNo, boolean update, UserModel userModel) {
		String msg = "\nHere are your Successful booking details for DOSE - " + doseNo + "\nVACCINE NAME :  "
				+ userModel.getVaccineName() + "\nLocation :  " + userModel.getFirstDoseVaccineLocation() + "\nDate :  "
				+ userModel.getFirstDoseDate();
		if (update) {
			msg = "\nYour Dose - " + doseNo + " booking is Successfully Updated\nDose Details\n" + "VACCINE NAME :  "
					+ userModel.getVaccineName() + "\nLOCATION :  " + userModel.getFirstDoseVaccineLocation()
					+ "\nDATE :  " + userModel.getFirstDoseDate();
		}
		Message.creator(new PhoneNumber("+91" + userModel.getMobileNumber()), new PhoneNumber("+19706018305"), msg)
				.create();
	}

	public void sendSecondDoseConfirmationMessage(String doseNo, boolean update, UserModel userModel) {
		String msg = "\nHere are your Successful booking details for DOSE - " + doseNo + "\nVACCINE NAME :  "
				+ userModel.getVaccineName() + "\nLocation :  " + userModel.getSecondDoseVaccineLocation()
				+ "\nDate :  " + userModel.getSecondDoseDate();
		if (update) {
			msg = "\nYour Dose - " + doseNo + " booking is Successfully Updated\nDose Details\n" + "VACCINE NAME :  "
					+ userModel.getVaccineName() + "\nLOCATION :  " + userModel.getSecondDoseVaccineLocation()
					+ "\nDATE :  " + userModel.getSecondDoseDate();
		}
		Message.creator(new PhoneNumber("+91" + userModel.getMobileNumber()), new PhoneNumber("+19706018305"), msg)
				.create();
	}

}
