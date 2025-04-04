package com.petclinic.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SpringBootTest
public class OwnerServiceTest {
	@Autowired OwnerService tested;
	
	@BeforeEach public void setup() {
		tested.save(new Owner(null, "Yngwie", "Malmsteen", 1000));
	}
	
	@Test public void should_find_by_first_name() {
		// Given
		// When
		var actual = tested.findByFirstName("Yngwie");
		// Test
		Assertions.assertThat(actual)
			.get()
			.extracting(Owner::getFirstName)
			.isEqualTo("Yngwie");
	}
}
