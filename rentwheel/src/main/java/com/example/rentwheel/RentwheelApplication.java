package com.example.rentwheel;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.example.rentwheel.config", "com.example.rentwheel.controller", "com.example.rentwheel.dao", "com.example.rentwheel.pojo","com.example.rentwheel.pojo.User"})
public class RentwheelApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentwheelApplication.class, args);
	}

}
