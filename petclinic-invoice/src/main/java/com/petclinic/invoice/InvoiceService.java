package com.petclinic.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
	@Autowired VisitService petclinicClient;
	
	@Value("${visit.price}")
	private double defaultVisitPrice;


	public Invoice generateInvoice(Long id) {
		Invoice returned = petclinicClient.generateInvoice(id);
		returned.setAmount(defaultVisitPrice);
		return returned;
	}
}
