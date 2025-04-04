package com.petclinic.core;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
	Optional<Owner> findByFirstName(String firstName);

	List<Owner> findAllByFirstName(String firstName);
}
