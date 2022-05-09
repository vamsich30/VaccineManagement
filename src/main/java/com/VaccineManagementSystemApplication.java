package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;

@SpringBootApplication
public class VaccineManagementSystemApplication {

	private static final String SID = "ACaa48d2d122c82a544d10e486dfbbecf9";

	private static final String authToken = "3cefddb7c16d286f8b3b817b7da4f1c0";

	public static void main(String[] args) {
		SpringApplication.run(VaccineManagementSystemApplication.class, args);
		Twilio.init(SID, authToken);
	}

}
