package com.endie.avizandum;

import com.endie.avizandum.service.SqsMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AwsProperties.class)
@SpringBootApplication
public class MaintenanceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MaintenanceApplication.class);
	@Autowired
	private SqsMessageSender sqsMessageSender;

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceApplication.class, args);
		
		logger.info("Application Started");
	}

	public void sendMessageToSQS(String message) {
		sqsMessageSender.sendMessage(message);
	}
}
