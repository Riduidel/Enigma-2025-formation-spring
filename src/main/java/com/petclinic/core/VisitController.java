package com.petclinic.core;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/visit")
public class VisitController {
	private static final Logger logger = LoggerFactory.getLogger(VisitController.class);
	@Autowired
	VisitService service;

	@GetMapping("/{id}")
	public Optional<Visit> findById(@PathVariable Long id) {
		logger.info("Searching for visit with id {}", id);
		return service.findById(id);
	}

}
