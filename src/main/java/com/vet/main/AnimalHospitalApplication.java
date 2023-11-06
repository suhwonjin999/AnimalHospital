package com.vet.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AnimalHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalHospitalApplication.class, args);
	}

}
