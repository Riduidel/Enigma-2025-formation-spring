package com.petclinic.core;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/owner")
public class OwnerController {
	private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);
	@Autowired
	OwnerService service;

	@GetMapping("/{id}")
	public Optional<Owner> findById(@PathVariable Long id) {
		logger.info("Searching for owner with id {}", id);
		return service.findById(id);
	}
	
	@PostMapping
	public Owner save(@RequestBody Owner owner) {
		return service.save(owner);
	}

	@GetMapping("/search")
	public List<Owner> findAllByFirstName(@RequestParam String firstName) {
		logger.info("Searching for owner with first name {}", firstName);
		return service.findAllByFirstName(firstName);
	}
}
