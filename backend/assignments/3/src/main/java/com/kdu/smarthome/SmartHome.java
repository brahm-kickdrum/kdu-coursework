package com.kdu.smarthome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.kdu")
@EnableJpaRepositories("com.kdu.smarthome.repository")
@EntityScan("com.kdu.smarthome.model")

public class SmartHome {
    public static void main(String[] args) {
        SpringApplication.run(SmartHome.class, args);
    }
}