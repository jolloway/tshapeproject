package com.barclays.tshapeproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TshapeprojectApplication {
	public enum Status { PENDING,UAT_TESTING,DEVELOPMENT,CLOSED}
	private static final Logger LOGGER = LogManager.getLogger();
	public static void main(String[] args) {
		LOGGER.info("Application beginning");
		SpringApplication.run(TshapeprojectApplication.class, args);

	}

}
