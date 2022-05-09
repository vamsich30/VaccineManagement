package com.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UsersDB")
@Getter
@Setter
public class UserModelEntity {
	@Id
	@Column(name = "aadharnumber", columnDefinition = "VARCHAR(64)")
	private String aadharNumber;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "age")
	private int age;
	
	@Column(name="mobilenumber")
	private String mobileNumber;

	@Column(name = "userdose1status")
	private boolean doseOne;

	@Column(name = "userdose2status")
	private boolean doseTwo;

	@Column(name = "vaccinename")
	private String vaccineName;

	@Column(name = "firstdosedate")
	private LocalDate firstDoseDate;

	@Column(name = "seconddosedate")
	private LocalDate secondDoseDate;

	@Column(name = "firstdosevaccinelocation")
	private String firstDoseVaccineLocation;

	@Column(name = "seconddosevaccinelocation")
	private String secondDoseVaccineLocation;

}
