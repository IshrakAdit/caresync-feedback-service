package com.caresync.service.feedback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeedbackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("CareSync Feedback Service");
	}

}
