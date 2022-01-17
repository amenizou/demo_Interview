package com.covid.demo.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * Represents a covid Case.
 * A patient can be vaccinated just one time .
 */
@Entity
@Table(name="covid_vaccin")
public class CovidVaccination{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id_Covid_Vaccin",updatable = false, nullable = false, unique = true)
	private Long idCovidVaccin;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-YYYY")
	@Column(name="firstVaccinDate")
	private LocalDate firstVaccinDate ;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-YYYY")
	@Column(name="secondVaccinDate")
	private LocalDate secondVaccinDate;
	
	@OneToOne
	@JoinColumn(name = "id_patient")
    private Patient patient;

	public long getIdCovidVaccin() {
		return idCovidVaccin;
	}

	public void setIdCovidVaccin(long idCovidVaccin) {
		this.idCovidVaccin = idCovidVaccin;
	}

	public LocalDate getFirstVaccinDate() {
		return firstVaccinDate;
	}

	public void setFirstVaccinDate(LocalDate firstVaccinDate) {
		this.firstVaccinDate = firstVaccinDate;
	}

	public LocalDate getSecondVaccinDate() {
		return secondVaccinDate;
	}

	public void setSecondVaccinDate(LocalDate secondVaccinDate) {
		this.secondVaccinDate = secondVaccinDate;
	}

	public void setIdCovidVaccin(Long idCovidVaccin) {
		this.idCovidVaccin = idCovidVaccin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public CovidVaccination() {
		super();
	}

	@Override
	public String toString() {
		return "CovidVaccination [idCovidVaccin=" + idCovidVaccin + ", firstVaccinDate=" + firstVaccinDate
				+ ", secondVaccinDate=" + secondVaccinDate + ", patient=" + patient + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstVaccinDate, idCovidVaccin, patient, secondVaccinDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CovidVaccination other = (CovidVaccination) obj;
		return Objects.equals(firstVaccinDate, other.firstVaccinDate)
				&& Objects.equals(idCovidVaccin, other.idCovidVaccin) && Objects.equals(patient, other.patient)
				&& Objects.equals(secondVaccinDate, other.secondVaccinDate);
	}
	
	
	
	
}
