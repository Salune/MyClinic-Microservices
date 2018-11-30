package com.ensi.ilsi.myclinic.DoctorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableCircuitBreaker
@SpringBootApplication
public class DoctorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorServiceApplication.class, args);
	}
}
