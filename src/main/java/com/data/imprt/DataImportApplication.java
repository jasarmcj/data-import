package com.data.imprt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DataImportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataImportApplication.class, args);
	}

}
