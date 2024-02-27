package com.endie.avizandum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaintenanceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MaintenanceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceApplication.class, args);
		
		logger.info("Application Started");
	}


}
