package com.petclinic.invoice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class PetclinicInvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetclinicInvoiceApplication.class, args);
	}

	@Value("${petclinic.endpoint}")
	private String endpointUrl;

	@Bean
	public RestClient restClient() {
		return RestClient.create(endpointUrl);
	}
}
