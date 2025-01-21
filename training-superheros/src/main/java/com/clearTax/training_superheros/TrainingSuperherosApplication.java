package com.clearTax.training_superheros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TrainingSuperherosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingSuperherosApplication.class, args);
	}
}