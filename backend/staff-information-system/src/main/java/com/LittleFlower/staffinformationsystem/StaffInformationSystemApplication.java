package com.LittleFlower.staffinformationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.LittleFlower.staffinformationsystem.model")
public class StaffInformationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffInformationSystemApplication.class, args);
	}

}
