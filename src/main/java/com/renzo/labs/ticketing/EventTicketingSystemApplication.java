package com.renzo.labs.ticketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.renzo.labs.ticketing")
@EnableJpaRepositories(basePackages = "com.renzo.labs.ticketing")
public class EventTicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventTicketingSystemApplication.class, args);
	}

}
