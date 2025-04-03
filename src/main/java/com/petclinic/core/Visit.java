package com.petclinic.core;

import java.time.LocalDate;
import java.util.Objects;

record Visit(long id,
		String referenceNumber,
		LocalDate date,
		String purpose) {
}
