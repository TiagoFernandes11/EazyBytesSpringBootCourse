package com.udemy.SimpleSpringWebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SimpleSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringWebApplication.class, args);
	}

}
