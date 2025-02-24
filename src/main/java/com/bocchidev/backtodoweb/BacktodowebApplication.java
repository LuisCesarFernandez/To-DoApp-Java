package com.bocchidev.backtodoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BacktodowebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacktodowebApplication.class, args);
	}

}
