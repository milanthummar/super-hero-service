package com.superhero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootApplication
public class SuperHeroServiceApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(SuperHeroServiceApplication.class, args);

	}
}
