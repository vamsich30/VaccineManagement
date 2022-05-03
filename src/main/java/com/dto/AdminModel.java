package com.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminModel {
	
	@NotBlank(message = "Admin Name cannot be empty")
	private String adminName;
	
	@NotBlank(message = "Admin Password cannot be empty")
	private String adminPassword;
}
