package com.petclinic.core;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SpringBootTest
public class OwnerServiceTest {
	@Autowired OwnerService tested;
	
	@BeforeEach public void setup() {
		Owner owner = new Owner(null, "Yngwie", "Malmsteen", 1000);
		owner.setPets(List.of(new Pet(null, "dog", "Luna"), new Pet(null, "cat", "Miro")));
		tested.save(owner);
	}
	
	@Test @Transactional public void should_find_by_first_name() {
		// Given
		// When
		var actual = tested.findByFirstName("Yngwie");
		// Test
		Assertions.assertThat(actual)
			.get()
			.extracting(Owner::getFirstName)
			.isEqualTo("Yngwie");
	}
	@Test @Transactional public void should_find_owner_with_pets() {
		// Given
		// When
		var actual = tested.findByFirstName("Yngwie");
		// Test
		Assertions.assertThat(actual)
			.get()
			.extracting(Owner::getPets)
			.asInstanceOf(InstanceOfAssertFactories.list(Pet.class))
			.extracting(Pet::getName)
			.contains("Luna")
			;
	}
}
