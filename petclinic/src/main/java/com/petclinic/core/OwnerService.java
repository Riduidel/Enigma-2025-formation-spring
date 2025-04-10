package com.petclinic.core;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class OwnerService {
	@Autowired OwnerRepository ownerRepository;

	public Optional<Owner> findByFirstName(String firstName) {
		return ownerRepository.findByFirstName(firstName);
	}

	public Owner save(Owner entity) {
		return ownerRepository.save(entity);
	}
	@Transactional
	public void transferFunds(Owner ownerToCredit, Owner ownerToDebit, double amount) {
	    creditAmount(ownerToCredit, amount);
	    debitAmount(ownerToDebit, amount);
	}

	private void debitAmount(Owner ownerToDebit, double amount) {
	    double ownerToDebitNewAmount = ownerToDebit.getAccountStatement() - amount;
	    if (ownerToDebitNewAmount < 0)
	        throw new RuntimeException("account value cannot be below zero");
	    ownerToDebit.setAccountStatement(ownerToDebitNewAmount);
	    this.ownerRepository.save(ownerToDebit);
	}

	private void creditAmount(Owner ownerToCredit, double amount) {
	    double ownerToCreditNewAmount = ownerToCredit.getAccountStatement() + amount;
	    ownerToCredit.setAccountStatement(ownerToCreditNewAmount);
	    this.ownerRepository.save(ownerToCredit);
	}

	public Optional<Owner> findById(Long id) {
		return ownerRepository.findById(id);
	}

	public List<Owner> findAllByFirstName(String firstName) {
		return ownerRepository.findAllByFirstName(firstName);
	}
}
