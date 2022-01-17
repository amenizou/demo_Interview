/**
 * 
 */
package com.covid.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.covid.demo.DTO.CovidCasesPerPeriod;
import com.covid.demo.entities.CovidCase;

/**
 * @author ameni.zouaoui
 *
 */
public interface CovidCaseService {

	public CovidCase insertCovidPatient(CovidCase covidCase);
	public List<CovidCase> findAll();
	public Optional<CovidCase> findById(Long id);
	public CovidCase updateCovidCase(Long idCovidCase, CovidCase covidCase);
	public Page<CovidCasesPerPeriod> findCovidCasesPerDay(String country,boolean testResult, int offset, int page);
	public Page<CovidCasesPerPeriod> findCovidCasesPerYear(String country,boolean testResult, int offset, int page);
	public Page<CovidCasesPerPeriod> findCovidCasesPerMonth(String country,boolean testResult, int offset, int page);


	
}
