/**
 * 
 */
package com.covid.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.covid.demo.DTO.CovidCasesPerPeriod;
import com.covid.demo.entities.CovidCase;

/**
 * @author ameni.zouaoui
 *
 */
@Repository
public interface CovidCaseRepository extends JpaRepository<CovidCase, Long>{
	
	/**
	 * Represents a Query to get total of covidCases daily.
	 */
	@Query(value ="SELECT "  + 
			"new com.covid.demo.DTO.CovidCasesPerPeriod(COUNT(*),cc.testDate) " + 
			"FROM " +
			"CovidCase cc, Patient p " + 
			"where cc.patient.idPatient = p.idPatient and cc.testResult = :testResult and p.country.idCountry =:country " + 
			"Group By"  + " cc.testDate" )
	Page<CovidCasesPerPeriod> findCovidCasesPerDay(@Param("country") String country, @Param("testResult")boolean testResult, Pageable pageable);

	
	/**
	 * Represents a Query to get total of covidCases per year.
	 */
	@Query(value ="SELECT "  + 
			"new com.covid.demo.DTO.CovidCasesPerPeriod(COUNT(*),Extract (year from cc.testDate)) " + 
			"FROM " +
			"CovidCase cc, Patient p " + 
			"where cc.patient.idPatient = p.idPatient and cc.testResult = :testResult and p.country.idCountry =:country " + 
			"Group By"  + " Extract (year from cc.testDate)" )
	Page<CovidCasesPerPeriod> findCovidCasesPerYear(@Param("country") String country, @Param("testResult")boolean testResult, Pageable pageable);
	
	/**
	 * Represents a Query to get total of covidCases per month.
	 */
	@Query(value ="SELECT "  + 
			"new com.covid.demo.DTO.CovidCasesPerPeriod(COUNT(*),Extract (month from cc.testDate)) " + 
			"FROM " +
			"CovidCase cc, Patient p " + 
			"where cc.patient.idPatient = p.idPatient and cc.testResult = :testResult and p.country.idCountry =:country " + 
			"Group By"  + " Extract (month from cc.testDate) " )
	Page<CovidCasesPerPeriod> findCovidCasesPerMonth(@Param("country") String country, @Param("testResult")boolean testResult, Pageable pageable);
}
