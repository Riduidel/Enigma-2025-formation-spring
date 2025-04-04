package com.petclinic.core;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

@Repository
public class VisitRepository {
	public Visit findByReferenceNumber(long id) {
		if(id==1) {
			return new Visit(1, "1", LocalDate.now(), "mock visit");
		} else {
			throw new RuntimeException("pas trouvé");
		}
	}
}
