package com.covid.demo.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents a Covid Case.
 * A patient can test many times .
 */
@Entity
@Table(name="covid_case")
public class CovidCase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_covid_case",updatable = false, nullable = false, unique = true)
	private Long idCovidCase;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-YYYY")
	@Column(name="testDate")
	private LocalDate testDate ;
	
	@Column(name="testResult")
	private boolean testResult;
	
	@ManyToOne
	@JoinColumn(name = "id_patient")
	private Patient patient;



	

	public boolean isTestResult() {
		return testResult;
	}

	public void setTestResult(boolean testResult) {
		this.testResult = testResult;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Long getIdCovidCase() {
		return idCovidCase;
	}

	public void setIdCovidCase(Long idCovidCase) {
		this.idCovidCase = idCovidCase;
	}
	
	

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}

	public CovidCase() {
		super();
	}

	@Override
	public String toString() {
		return "CovidCase [idCovidCase=" + idCovidCase + ", testDate=" + testDate + ", testResult=" + testResult
				+ ", patient=" + patient + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCovidCase, patient, testDate, testResult);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CovidCase other = (CovidCase) obj;
		return Objects.equals(idCovidCase, other.idCovidCase) && Objects.equals(patient, other.patient)
				&& Objects.equals(testDate, other.testDate) && testResult == other.testResult;
	}
	
	
	
	
}
