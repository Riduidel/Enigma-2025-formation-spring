package com.petclinic.invoice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class InvoiceService {
	@Autowired RestClient petclinicClient;
	
	@Value("${visit.price}")
	private double defaultVisitPrice;


	public Invoice generateInvoice(Long id) {
		Invoice returned = petclinicClient
				.get()
				.uri(String.format("visit/%d", id))
				.retrieve()
				.body(Invoice.class);
		returned.setAmount(defaultVisitPrice);
		return returned;
	}
}
