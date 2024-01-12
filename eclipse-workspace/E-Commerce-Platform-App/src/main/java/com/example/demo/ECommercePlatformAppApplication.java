package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo.model")
public class ECommercePlatformAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePlatformAppApplication.class, args);
	}

}
