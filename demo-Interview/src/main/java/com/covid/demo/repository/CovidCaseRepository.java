/**
 * 
 */
package com.covid.demo.repository;

import java.util.List;

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
			"new com.covid.demo.DTO.CovidCasesPerPeriod(COUNT(*),cc.testDate)" + 
			"FROM " +
			"CovidCase cc, Patient p " + 
			"where cc.patient.idPatient = p.idPatient and cc.testResult = :testResult and p.country.idCountry =:country " + 
			"Group By" + " cc.testDate")
	List<CovidCasesPerPeriod> findCovidCasesPerDay(@Param("country") String country, @Param("testResult")boolean testResult);

	
	/**
	 * Represents a Query to get total of covidCases per year.
	 */
	@Query(value ="SELECT "  + 
			"new com.covid.demo.DTO.CovidCasesPerPeriod(COUNT(*),cc.testDate) " + 
			"FROM " +
			"CovidCase cc, Patient p " + 
			"where cc.patient.idPatient = p.idPatient and cc.testResult = :testResult and p.country.idCountry =:country " + 
			"Group By"  + " Extract (year from cc.testDate) , cc.testDate" )
	List<CovidCasesPerPeriod> findCovidCasesPerYear(@Param("country") String country, @Param("testResult")boolean testResult);
	
	/**
	 * Represents a Query to get total of covidCases per month.
	 */
	@Query(value ="SELECT "  + 
			"new com.covid.demo.DTO.CovidCasesPerPeriod(COUNT(*),cc.testDate) " + 
			"FROM " +
			"CovidCase cc, Patient p " + 
			"where cc.patient.idPatient = p.idPatient and cc.testResult = :testResult and p.country.idCountry =:country " + 
			"Group By"  + " Extract (month from cc.testDate) , Extract (year from cc.testDate) , cc.testDate" )
	List<CovidCasesPerPeriod> findCovidCasesPerMonth(@Param("country") String country, @Param("testResult")boolean testResult);
}
