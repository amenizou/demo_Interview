package com.covid.demo.DTO;

import java.time.LocalDate;
import java.util.Date;

import com.covid.demo.entities.Country;
public class CovidCasesPerPeriod {
	
	
	private Long nbCovidCases;
	private LocalDate testDate;
	
	
	public CovidCasesPerPeriod(Long nbCovidCases, LocalDate testDate) {
		super();
		this.nbCovidCases = nbCovidCases;
		this.testDate = testDate;
	}
	public Long getNbCovidCases() {
		return nbCovidCases;
	}
	public void setNbCovidCases(Long nbCovidCases) {
		this.nbCovidCases = nbCovidCases;
	}
	public LocalDate getTestDate() {
		return testDate;
	}
	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}
	
	

	
	
	

}
