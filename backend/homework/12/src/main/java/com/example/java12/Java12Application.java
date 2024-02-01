package com.example.java12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.java12.repository")
@EntityScan("com.example.java12.model")
public class Java12Application {

	public static void main(String[] args) {
		SpringApplication.run(Java12Application.class, args);
	}

}
