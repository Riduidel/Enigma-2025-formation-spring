package com.petclinic.invoice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface VisitService {
	@GetExchange("visit/{id}")
	Invoice generateInvoice(@PathVariable Long id);
}
