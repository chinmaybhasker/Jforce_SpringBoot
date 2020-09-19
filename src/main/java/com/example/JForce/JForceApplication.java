package com.example.JForce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.JForce.controller","com.example.JForce.service","com.example.JForce.repositry"})
public class JForceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JForceApplication.class, args);
	}

}
