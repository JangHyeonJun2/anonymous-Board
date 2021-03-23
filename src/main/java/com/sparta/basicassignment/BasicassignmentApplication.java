package com.sparta.basicassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasicassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicassignmentApplication.class, args);
	}

}
