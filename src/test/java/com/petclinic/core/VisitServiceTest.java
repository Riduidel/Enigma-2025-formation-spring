package com.petclinic.core;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VisitServiceTest {
	@Autowired VisitService tested;

	@Test
	void should_find_by__correct_reference_number() {
		long ID = 1;
		// Given
		// When
		Visit visit = tested.findByReferenceNumber(ID);
		// Then
		Assertions.assertThat(visit.id())
			.describedAs("The returned visit has the correct id")
			.isEqualTo(ID);
		Assertions.assertThat(visit)
			.isEqualTo(new Visit(1, "1", LocalDate.now(), "mock visit"));
	}


	@Test
	void should_fail_when_id_is_incorrect() {
		long ID = 0;
		// Given
		// When
		Visit visit = tested.findByReferenceNumber(ID);
		// Then
		Assertions.assertThat(visit)
			.describedAs("When id is incorrect, null is returned")
			.isNull();
	}
}
