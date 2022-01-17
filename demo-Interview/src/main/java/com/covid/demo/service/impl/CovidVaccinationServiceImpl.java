/**
 * 
 */
package com.covid.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.demo.DTO.VaccinationCasesPerPeriod;
import com.covid.demo.entities.CovidVaccination;
import com.covid.demo.entities.Patient;
import com.covid.demo.repository.CovidVaccinationRepository;
import com.covid.demo.repository.PatientRepository;
import com.covid.demo.service.CovidVaccinationService;

/**
 * @author ameni.zouaoui
 *
 */
@Service
public class CovidVaccinationServiceImpl implements CovidVaccinationService{
	
	@Autowired
	CovidVaccinationRepository covidVaccinationRepository;

	@Autowired
	PatientRepository patientRepository;

	public CovidVaccination insertVaccinPatient(CovidVaccination covidVaccination) {
		CovidVaccination c;
		if (patientRepository.findById(covidVaccination.getPatient().getIdPatient()).isPresent()) {
			c = covidVaccinationRepository.save(covidVaccination);
		} else {
			patientRepository.save(covidVaccination.getPatient());
			c = covidVaccinationRepository.save(covidVaccination);
		}
		return c;
	}
	
	public CovidVaccination updateVaccinCase(Long idCovidVaccin, CovidVaccination covidVaccin) {
		Optional<CovidVaccination> covidVaccinSearched = covidVaccinationRepository.findById(idCovidVaccin);
		CovidVaccination c = null;

		if (covidVaccinSearched.isPresent()) {
			c = covidVaccinSearched.get();
			c.setFirstVaccinDate(covidVaccin.getFirstVaccinDate());
			c.setSecondVaccinDate(covidVaccin.getSecondVaccinDate());

			Patient p = covidVaccinSearched.get().getPatient();
			p.setFirstName(covidVaccin.getPatient().getFirstName());
			p.setLastName(covidVaccin.getPatient().getLastName());
			p.setAdress(covidVaccin.getPatient().getAdress());
			p.setDateOfBirth(covidVaccin.getPatient().getDateOfBirth());

			p.setCountry(covidVaccin.getPatient().getCountry());

			c.setPatient(p);
		}
		return covidVaccinationRepository.save(c);
	}

	public List<CovidVaccination> findAll() {
		return covidVaccinationRepository.findAll();

	}

	@Override
	public Optional<CovidVaccination> findById(Long id) {
		return covidVaccinationRepository.findById(id);
	}

	@Override
	public List<VaccinationCasesPerPeriod> findFirstVaccinationCasesPerDay(String country) {
		return covidVaccinationRepository.findFirstVaccinationCasesPerDay(country);
	}

	@Override
	public List<VaccinationCasesPerPeriod> findSecondVaccinationCasesPerDay(String country) {
		return covidVaccinationRepository.findSecondVaccinationCasesPerDay(country);
	}

	@Override
	public List<VaccinationCasesPerPeriod> findFirstVaccinationPerYear(String country) {
		return covidVaccinationRepository.findFirstVaccinationPerYear(country);
	}

	@Override
	public List<VaccinationCasesPerPeriod> findSecondVaccinationPerYear(String country) {
		return covidVaccinationRepository.findSecondVaccinationPerYear(country);
	}

	@Override
	public List<VaccinationCasesPerPeriod> findFirstVaccinationPerMonth(String country) {
		return covidVaccinationRepository.findFirstVaccinationPerMonth(country);
	}

	@Override
	public List<VaccinationCasesPerPeriod> findSecondVaccinationPerMonth(String country) {
		return covidVaccinationRepository.findSecondVaccinationPerMonth(country);
	}
}
