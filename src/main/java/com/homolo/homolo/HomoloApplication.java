package com.homolo.homolo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HomoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomoloApplication.class, args);
	}

}
