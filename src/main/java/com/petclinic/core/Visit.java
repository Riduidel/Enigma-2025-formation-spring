package com.petclinic.core;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Visit {
	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String referenceNumber;
	private LocalDate date;
	private String purpose;
	
	public Visit() {}

	public Visit(Long id, String referenceNumber, LocalDate date, String purpose) {
		super();
		this.id = id;
		this.referenceNumber = referenceNumber;
		this.date = date;
		this.purpose = purpose;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, purpose, referenceNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		return Objects.equals(date, other.date) && id == other.id && Objects.equals(purpose, other.purpose)
				&& Objects.equals(referenceNumber, other.referenceNumber);
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", referenceNumber=" + referenceNumber + ", date=" + date + ", purpose=" + purpose
				+ "]";
	}
	
}
