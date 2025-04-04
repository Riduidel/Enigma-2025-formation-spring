package com.petclinic.core;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

@Repository
public class VisitRepository {
	public Visit findByReferenceNumber(String id) {
		return new Visit(1, "1", LocalDate.now(), "mock visit");
	}
}
