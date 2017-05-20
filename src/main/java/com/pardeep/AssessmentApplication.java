package com.pardeep;

import com.github.javafaker.Faker;
import com.pardeep.model.User;
import com.pardeep.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class AssessmentApplication {

	private final Faker faker = new Faker();

	@RequestMapping("/")
	public String home() {
		return "Hello World! The Application is working!!!";
	}



	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}
}
