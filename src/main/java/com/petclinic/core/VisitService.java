package com.petclinic.core;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

	@Autowired VisitRepository repository;

	public Optional<Visit> findByReferenceNumber(String ref) {
		return repository.findByReferenceNumber(ref);
	}

	public Visit save(Visit entity) {
		return repository.save(entity);
	}

	public Optional<Visit> findById(Long id) {
		return repository.findById(id);
	}
}
