package com.petclinic.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SpringBootTest
class OwnerServiceTransactionsTest {

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
}
