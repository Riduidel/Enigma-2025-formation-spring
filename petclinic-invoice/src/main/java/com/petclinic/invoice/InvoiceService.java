package com.petclinic.invoice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class InvoiceService {
	@Autowired RestClient petclinicClient;

	public Invoice generateInvoice(Long id) {
		return petclinicClient
				.get()
				.uri(String.format("visit/%d", id))
				.retrieve()
				.body(Invoice.class);
	}
}
