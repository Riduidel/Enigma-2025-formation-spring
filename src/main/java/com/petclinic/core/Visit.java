package com.petclinic.core;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Visit {
	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String referenceNumber;
	private LocalDate date;
	private String purpose;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Pet pet;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Owner owner;
	
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

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, pet, purpose, referenceNumber);
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
		return Objects.equals(date, other.date) && Objects.equals(id, other.id) && Objects.equals(pet, other.pet)
				&& Objects.equals(purpose, other.purpose) && Objects.equals(referenceNumber, other.referenceNumber);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Visit [id=").append(id)
			.append(", referenceNumber=")
			.append(referenceNumber).append(", date=")
			.append(date).append(", purpose=").append(purpose)
			.append(", pet=").append(pet).append("]");
		return builder.toString();
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
}
