package com.dto;

import com.enums.Country;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
	private String userName;
	private int age;
	private String gender;
	private Country.countryList nationality;

	private float feverDegree;
	private boolean cough = false;
	private boolean fetigue = false;
	private boolean coughingUpSputum = false;
	private boolean shortnessOfBreath = false;
	private boolean boneOrJointPain = false;
	private boolean headache = false;
	private boolean soreThroat = false;
	private boolean chills = false;
	private boolean nauseaOrVomiting = false;
	private boolean stuffyNose = false;
	private boolean specialDiseases = false;
	private boolean diarrhea = false;
}
