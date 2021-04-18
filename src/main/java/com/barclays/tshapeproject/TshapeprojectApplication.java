package com.barclays.tshapeproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.security.krb5.internal.Ticket;

import java.time.LocalDate;

@SpringBootApplication
public class TshapeprojectApplication {
	public enum Status { PENDING,UAT_TESTING,DEVELOPMENT,CLOSED}
	private static final Logger LOGGER = LogManager.getLogger();
	public static void main(String[] args) {
		LOGGER.info("Application beginning");
		SpringApplication.run(TshapeprojectApplication.class, args);

	}

	/*@Bean
	public CommandLineRunner demo(TicketEntity repository) {
		return (args) -> {
			// save a few customers
			repository.save(new TicketRepository<>("TEST1", "I HATE JIRA", Status.DEVELOPMENT, "I DONT WORK", LocalDate.now()));


			// fetch all customers
			LOGGER.info("Customers found with findAll():");
			LOGGER.info("-------------------------------");
			for (Ticket ticket : repository.findAll()) {
				LOGGER.info(Ticket.toString);
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}*/


}
