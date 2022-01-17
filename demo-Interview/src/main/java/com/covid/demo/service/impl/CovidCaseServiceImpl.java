/**
 * 
 */
package com.covid.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.covid.demo.DTO.CovidCasesPerPeriod;
import com.covid.demo.entities.CovidCase;
import com.covid.demo.entities.Patient;
import com.covid.demo.repository.CovidCaseRepository;
import com.covid.demo.repository.PatientRepository;
import com.covid.demo.service.CovidCaseService;

/**
 * @author ameni.zouaoui
 *
 */
@Service
public class CovidCaseServiceImpl implements CovidCaseService{
	@Autowired
	CovidCaseRepository covidCaseRepository;
	
	@Autowired
	PatientRepository patientRepository;

	/**
	 * Represents a service.
	 * to insert covidCase if patient is present / insert patient + covid case if not
	 */
	public CovidCase insertCovidPatient(CovidCase covidCase) {
		CovidCase c;

		if (patientRepository.findById(covidCase.getPatient().getIdPatient()).isPresent()) {
			c = covidCaseRepository.save(covidCase);
		} else {
			patientRepository.save(covidCase.getPatient());
			c = covidCaseRepository.save(covidCase);
		}

		return c;
	}

	/**
	 * Represents a service.
	 * to update covidCase with patient details
	 */
	public CovidCase updateCovidCase(Long idCovidCase, CovidCase covidCase) {
		Optional<CovidCase> covidCaseSearched = covidCaseRepository.findById(idCovidCase);
		CovidCase c = new CovidCase();

		if (covidCaseSearched.isPresent()) {
			c = covidCaseSearched.get();
			c.setTestDate(covidCase.getTestDate());
			c.setTestResult(covidCase.isTestResult());

			Patient p = covidCaseSearched.get().getPatient();
			p.setFirstName(covidCase.getPatient().getFirstName());
			p.setLastName(covidCase.getPatient().getLastName());
			p.setAdress(covidCase.getPatient().getAdress());
			p.setDateOfBirth(covidCase.getPatient().getDateOfBirth());

			p.setCountry(covidCase.getPatient().getCountry());

			c.setPatient(p);
		}
		return covidCaseRepository.save(c);
	}
	/**
	 * Represents a service.
	 * to get All covidCases
	 */
	public List<CovidCase> findAll() {
		return covidCaseRepository.findAll();

	}

	@Override
	public Optional<CovidCase> findById(Long id) {
		return covidCaseRepository.findById(id);
	}
	
	/**
	 * Represents a service.
	 * to find Covid Cases Per Day
	 */
	@Override
	public Page<CovidCasesPerPeriod> findCovidCasesPerDay(String country, boolean testResult, int offset, int page) {
		return covidCaseRepository.findCovidCasesPerDay(country, testResult,PageRequest.of(offset,page));
	}

	/**
	 * Represents a service.
	 * to find Covid Cases Per Year
	 */
	@Override
	public Page<CovidCasesPerPeriod> findCovidCasesPerYear(String country, boolean testResult, int offset, int page) {
		return covidCaseRepository.findCovidCasesPerYear(country, testResult, PageRequest.of(offset,page));
	}
	/**
	 * Represents a service.
	 * to find Covid Cases Per Month
	 */
	@Override
	public Page<CovidCasesPerPeriod> findCovidCasesPerMonth(String country, boolean testResult, int offset, int page) {
		return covidCaseRepository.findCovidCasesPerMonth(country, testResult, PageRequest.of(offset,page));
	}
    

}
