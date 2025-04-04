package com.petclinic.core;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
	@Autowired OwnerRepository ownerRepository;

	public Optional<Owner> findByFirstName(String firstName) {
		return ownerRepository.findByFirstName(firstName);
	}

	public Owner save(Owner entity) {
		return ownerRepository.save(entity);
	}
}
