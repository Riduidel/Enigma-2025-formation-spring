package com.petclinic.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

	@Autowired VisitRepository repository;

	public Visit findByReferenceNumber(String ref) {
		return repository.findByReferenceNumber(ref);
	}
}
