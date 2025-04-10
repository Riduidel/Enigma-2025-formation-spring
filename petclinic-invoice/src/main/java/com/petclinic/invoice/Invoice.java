package com.petclinic.invoice;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {
    @JsonProperty("date")
    private LocalDate visitDate;
    @JsonProperty("purpose")
    private String visitPurpose;
    
    private double amount;

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public String getVisitPurpose() {
        return visitPurpose;
    }

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}