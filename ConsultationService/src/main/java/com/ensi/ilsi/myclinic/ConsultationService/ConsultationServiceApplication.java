package com.ensi.ilsi.myclinic.ConsultationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class ConsultationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultationServiceApplication.class, args);
	}
}