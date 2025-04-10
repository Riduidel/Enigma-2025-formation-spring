package com.petclinic.core;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SpringBootTest
class OwnerServiceTransactionsTest {
	@Autowired OwnerService ownerService;
	@Test void should_not_run_in_transaction() {
		Assertions.assertThat(TransactionSynchronizationManager.isActualTransactionActive())
			.describedAs("Method is not annotated @%s, so no transaction should be started", Transactional.class.getSimpleName())
			.isFalse();
	}

	@Test @Transactional void should_run_in_transaction() {
		Assertions.assertThat(TransactionSynchronizationManager.isActualTransactionActive())
			.describedAs("Method is annotated @%s, so one transaction should be started", Transactional.class.getSimpleName())
			.isTrue();
	}

	@Test @Transactional
	public void shouldTransferFunds() {
		// Given
	    var ownerToCredit = ownerService.save(new Owner(null, "Jimi","Hendrix", 0));
	    var ownerToDebit = ownerService.save(new Owner(null, "Robert","Plant",1000));
		// When
	    ownerService.transferFunds(ownerToCredit, ownerToDebit, 200);
	    // Then
	    Assertions.assertThat(ownerService.findByFirstName("Jimi"))
	    	.get()
	    	.extracting(Owner::getAccountStatement)
	    	.asInstanceOf(InstanceOfAssertFactories.DOUBLE)
	    	.isEqualTo(200.0, Assertions.byLessThan(0.01));
	    Assertions.assertThat(ownerService.findByFirstName("Robert"))
	    	.get()
	    	.extracting(Owner::getAccountStatement)
	    	.asInstanceOf(InstanceOfAssertFactories.DOUBLE)
	    	.isEqualTo(800.0, Assertions.byLessThan(0.01));
	}

	@Test @Transactional
	public void should_fail_transfer_because_amount_below_zero() {
		// Given
	    var ownerToCredit = ownerService.save(new Owner(null, "Jimi","Hendrix", 0));
	    var ownerToDebit = ownerService.save(new Owner(null, "Robert","Plant",1000));
		// When
	    Assertions.assertThatThrownBy(() -> ownerService.transferFunds(ownerToCredit, ownerToDebit, 1200))
		    // Then
	    	.isInstanceOf(RuntimeException.class);
	}
}
