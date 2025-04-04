package com.petclinic.core;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SpringBootTest
class VisitServiceTest {
	private static final String ID = "V01-23";

	@Autowired VisitService tested;

	@BeforeEach
	public void setup() {
	    var visit = new Visit(null, ID, LocalDate.of(2013, 12, 21), "Teeth whitening");
	    visit.setPet(new Pet(null, "dog", "luna"));
	    tested.save(visit);
	}
	
	@Test @Transactional
	void should_find_by_correct_reference_number() {
		// Given
		// When
		var visit = tested.findByReferenceNumber(ID);
		// Then
		Assertions.assertThat(visit)
			.get()
			.extracting(Visit::getReferenceNumber)
			.isEqualTo(ID)
			;
		Assertions.assertThat(visit)
			.get()
			.extracting(Visit::getPet)
			.extracting(Pet::getName)
			.isEqualTo("luna")
			;
	}
	
	@Test @Transactional
	void should_not_find_visit_with_unknown_reference_number() {
		// Given
		// When
		var visit = tested.findByReferenceNumber("this reference number doesn't exists");
		// Then
		Assertions.assertThat(visit)
			.describedAs("When reference number doesn't exist, no Visit should be returned")
			.isEmpty();
	}
}
