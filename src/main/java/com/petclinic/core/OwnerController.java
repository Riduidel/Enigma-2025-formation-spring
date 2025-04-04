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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController @RequestMapping("/owner")
public class OwnerController {
	private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);
	@Autowired
	OwnerService service;

	@Operation(description = "Get an owner by its id")
	@GetMapping("/{id}")
	public Optional<Owner> findById(
			@Parameter(description = "Owner id")
			@PathVariable Long id) {
		logger.info("Searching for owner with id {}", id);
		return service.findById(id);
	}
	
	@Operation(description = "Adds a new owner to the database")
	@PostMapping
	public Owner save(
			@Parameter(description = "Full owner object. Notice that, if an id is given in the body, this will alter the existing owner.")
			@RequestBody Owner owner) {
		return service.save(owner);
	}

	@Operation(description = "Search all owners having the given id")
	@GetMapping("/search")
	public List<Owner> findAllByFirstName(
			@Parameter(description = "Any string")
			@RequestParam String firstName) {
		logger.info("Searching for owner with first name {}", firstName);
		return service.findAllByFirstName(firstName);
	}
}
