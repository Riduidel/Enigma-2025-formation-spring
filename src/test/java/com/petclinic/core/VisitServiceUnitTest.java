package com.petclinic.core;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
public class VisitServiceUnitTest {
	@Mock VisitRepository repository;
	@InjectMocks VisitService service;
	
	@Test
	public void should_find_visit_by_reference_number() {
		// Given
		String REF = "1";
		int ID = 1;
		var visit = new Visit(ID, REF, LocalDate.now(), getClass().getSimpleName());
		Mockito.when(repository.findByReferenceNumber(ID)).thenReturn(visit);
		// When
		var returned = service.findByReferenceNumber(ID);
		// Then
		Assertions.assertThat(returned).isEqualTo(visit);
		// Optional
		Mockito.verify(repository, Mockito.times(1)).findByReferenceNumber(ID);
	}
}
