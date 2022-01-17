/**
 * 
 */
package com.covid.demo.service;

import java.util.List;
import java.util.Optional;

import com.covid.demo.DTO.VaccinationCasesPerPeriod;
import com.covid.demo.entities.CovidVaccination;

/**
 * @author ameni.zouaoui
 *
 */
public interface CovidVaccinationService {

	public CovidVaccination insertVaccinPatient(CovidVaccination covidVaccination);

	public List<CovidVaccination> findAll();

	public Optional<CovidVaccination> findById(Long id);

	public CovidVaccination updateVaccinCase(Long idCovidVaccin, CovidVaccination covidVaccination);

	public List<VaccinationCasesPerPeriod> findFirstVaccinationCasesPerDay(String country);

	public List<VaccinationCasesPerPeriod> findSecondVaccinationCasesPerDay(String country);

	public List<VaccinationCasesPerPeriod> findSecondVaccinationPerYear(String country);

	public List<VaccinationCasesPerPeriod> findFirstVaccinationPerYear(String country);

	public List<VaccinationCasesPerPeriod> findFirstVaccinationPerMonth(String country);

	public List<VaccinationCasesPerPeriod> findSecondVaccinationPerMonth(String country);
}
