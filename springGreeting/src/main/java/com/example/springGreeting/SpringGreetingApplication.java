package com.example.springGreeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.springGreeting")
public class SpringGreetingApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringGreetingApplication.class, args);
	}

}
