package com.covid.demo.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Represents a patient.
 * A patient is related to ONE country.
 */

@Entity
@Table(name="patient")
public class Patient {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_patient")
	private Long idPatient;

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "date_Of_Birth")
	private LocalDate dateOfBirth;

	@Column(name = "adress")
	private String adress;

	@ManyToOne
	@JoinColumn(name = "id_country")
	private Country country;

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Patient(Long idPatient, String firstName, String lastName, LocalDate dateOfBirth, String adress,
			Country country) {
		super();
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.country = country;
	}

	public Patient() {
	}

	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", adress=" + adress + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adress, country, dateOfBirth, firstName, idPatient, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(country, other.country)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(idPatient, other.idPatient) && Objects.equals(lastName, other.lastName);
	}

}
