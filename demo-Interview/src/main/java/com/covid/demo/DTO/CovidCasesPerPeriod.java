package com.covid.demo.DTO;

import java.time.LocalDate;
import java.util.Date;

import com.covid.demo.entities.Country;
public class CovidCasesPerPeriod {
	
	
	private Long nbCovidCases;
	private LocalDate testDate;
	private int yearMonth;
	
	
	
	public CovidCasesPerPeriod(Long nbCovidCases, int yearMonth) {
		super();
		this.nbCovidCases = nbCovidCases;
		this.yearMonth = yearMonth;
	}
	public int getYear() {
		return yearMonth;
	}
	public void setYear(int yearMonth) {
		this.yearMonth = yearMonth;
	}
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
