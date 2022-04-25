package com.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModel {

	@NotBlank(message = "Aadhaar Number cannot be empty")
	@Pattern(regexp = "[0-9]+", message = "Aadhaar number should contain only digits")
	@Size(min = 12, max = 12, message = "Aadhar Number should be 12 digits")
	String aadharNumber;

	@NotBlank(message = "User Name cannot be empty")
	@Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "UserName should contain only alphabets")
	String username;

	@NotBlank(message = "Password cannot be blank")
	String password;

	@NotNull(message = "Please enter your age")
	Integer age;
	boolean doseOne;
	boolean doseTwo;

	@NotBlank
	String vaccineName;

	LocalDate firstDoseDate;

	LocalDate secondDoseDate;

	@NotBlank
	String firstDoseVaccineLocation;
	String secondDoseVaccineLocation;

	@Override
	public String toString() {
		return " =============================User Details=========================\n" + "userName = " + username
				+ "\npassword = " + password + "\naadharNumber = " + aadharNumber + "\nage = " + age + "\ndose1 = "
				+ doseOne + "\ndose2 = " + doseTwo + "\nvaccineName = " + vaccineName + "\nfirstDoseDate = "
				+ firstDoseDate + "\nfirstDoseVaccineLocation = " + firstDoseVaccineLocation + "\nsecondDoseDate = "
				+ secondDoseDate + "\nsecondDoseVaccineLocation = " + secondDoseVaccineLocation
				+ "\n====================================================================";
	}
}
