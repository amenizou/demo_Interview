/**
 * 
 */
package com.covid.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.covid.demo.DTO.VaccinationCasesPerPeriod;
import com.covid.demo.entities.CovidVaccination;

/**
 * @author ameni.zouaoui
 *
 */
@Repository
public interface CovidVaccinationRepository extends JpaRepository<CovidVaccination, Long>{

	@Query(value = "SELECT "
			+ "new com.covid.demo.DTO.VaccinationCasesPerPeriod(COUNT(*),cv.firstVaccinDate )  "
			+ "FROM " + "CovidVaccination cv, Patient p "
			+ "where cv.patient.idPatient = p.idPatient and p.country.idCountry =:country "
			+ "GROUP BY" + " cv.firstVaccinDate ")
	List<VaccinationCasesPerPeriod> findFirstVaccinationCasesPerDay(@Param("country") String country);
	
	@Query(value = "SELECT "
			+ "new com.covid.demo.DTO.VaccinationCasesPerPeriod(COUNT(*),cv.secondVaccinDate )  "
			+ "FROM " + "CovidVaccination cv, Patient p "
			+ "where cv.patient.idPatient = p.idPatient and p.country.idCountry =:country "
			+ "GROUP BY" + " cv.secondVaccinDate ")
	List<VaccinationCasesPerPeriod> findSecondVaccinationCasesPerDay(@Param("country") String country);

	@Query(value = "SELECT "
			+ "new com.covid.demo.DTO.VaccinationCasesPerPeriod(COUNT(*),cv.secondVaccinDate )  "
			+ "FROM " + "CovidVaccination cv, Patient p "
			+ "where cv.patient.idPatient = p.idPatient and p.country.idCountry =:country "
			+ "GROUP BY" + " Extract (year from cv.firstVaccinDate)  , cv.firstVaccinDate ")
	List<VaccinationCasesPerPeriod> findFirstVaccinationPerYear(@Param("country") String country);
	
	@Query(value = "SELECT "
			+ "new com.covid.demo.DTO.VaccinationCasesPerPeriod(COUNT(*),cv.secondVaccinDate )  "
			+ "FROM " + "CovidVaccination cv, Patient p "
			+ "where cv.patient.idPatient = p.idPatient and p.country.idCountry =:country "
			+ "GROUP BY" + " Extract (year from cv.secondVaccinDate)  , cv.secondVaccinDate ")
	List<VaccinationCasesPerPeriod> findSecondVaccinationPerYear(@Param("country") String country);
	
	@Query(value = "SELECT "
			+ "new com.covid.demo.DTO.VaccinationCasesPerPeriod(COUNT(*),cv.secondVaccinDate )  "
			+ "FROM " + "CovidVaccination cv, Patient p "
			+ "where cv.patient.idPatient = p.idPatient and p.country.idCountry =:country "
			+ "GROUP BY" + " Extract (month from cv.firstVaccinDate) , Extract (year from cv.firstVaccinDate)  , cv.firstVaccinDate ")
	List<VaccinationCasesPerPeriod> findFirstVaccinationPerMonth(@Param("country") String country);
	
	@Query(value = "SELECT "
			+ "new com.covid.demo.DTO.VaccinationCasesPerPeriod(COUNT(*),cv.secondVaccinDate )  "
			+ "FROM " + "CovidVaccination cv, Patient p "
			+ "where cv.patient.idPatient = p.idPatient and p.country.idCountry =:country "
			+ "GROUP BY" + " Extract (month from cv.secondVaccinDate) , Extract (year from cv.secondVaccinDate)  , cv.secondVaccinDate ")
	List<VaccinationCasesPerPeriod> findSecondVaccinationPerMonth(@Param("country") String country);

}
