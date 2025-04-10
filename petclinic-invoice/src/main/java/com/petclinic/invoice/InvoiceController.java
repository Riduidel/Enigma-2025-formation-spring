package com.petclinic.invoice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController @RequestMapping("/invoice")
public class InvoiceController {
	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);
	@Autowired InvoiceService service;
	@Operation(description = "Get an owner by its id")
	@GetMapping("/{id}")
	public Invoice generateInvoice(
			@Parameter(description = "Visit id")
			@PathVariable Long id) {
		logger.info("Searching for invoice of visit with id {}", id);
		return service.generateInvoice(id);
	}

}
