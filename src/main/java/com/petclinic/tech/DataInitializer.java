package com.petclinic.tech;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.petclinic.core.Owner;
import com.petclinic.core.Pet;
import com.petclinic.core.Visit;
import com.petclinic.core.VisitService;

import jakarta.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class DataInitializer {
	@Autowired VisitService visitService;
	@PostConstruct
	public void initializeSampleData() {
	    Owner owner = new Owner(null, "joe", "satriani", 1000);
	    var pet1 = new Pet(null, "dog", "luna");
	    var visit = new Visit(null, "V01-23", LocalDate.of(2013, 12, 21), "Teeth whitening");
	    visit.setPet(pet1);
	    owner.setPets(List.of(pet1));
	    visit.setOwner(owner);
	    this.visitService.save(visit);
	}
}
