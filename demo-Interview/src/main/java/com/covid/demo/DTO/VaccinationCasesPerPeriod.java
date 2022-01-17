/**
 * 
 */
package com.covid.demo.DTO;

import java.time.LocalDate;

/**
 * @author ameni.zouaoui
 *
 */
public class VaccinationCasesPerPeriod {

	private Long nbVaccinCases;
	private LocalDate vaccinDate;

	public Long getNbVaccinCases() {
		return nbVaccinCases;
	}

	public void setNbVaccinCases(Long nbVaccinCases) {
		this.nbVaccinCases = nbVaccinCases;
	}

	public VaccinationCasesPerPeriod(Long nbVaccinCases, LocalDate vaccinDate) {
		super();
		this.nbVaccinCases = nbVaccinCases;
		this.vaccinDate = vaccinDate;
	}

	public LocalDate getVaccinDate() {
		return vaccinDate;
	}

	public void setVaccinDate(LocalDate vaccinDate) {
		this.vaccinDate = vaccinDate;
	}

	public VaccinationCasesPerPeriod() {

	}

}
