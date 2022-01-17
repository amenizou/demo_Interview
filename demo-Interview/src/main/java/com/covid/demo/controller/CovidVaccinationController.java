/**
 * 
 */
package com.covid.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.demo.DTO.CovidCasesPerPeriod;
import com.covid.demo.DTO.VaccinationCasesPerPeriod;
import com.covid.demo.entities.CovidVaccination;
import com.covid.demo.service.CovidVaccinationService;

/**
 * @author ameni.zouaoui
 *
 */
@RequestMapping("/api/vaccin")
@RestController
public class CovidVaccinationController {
	
	@Autowired
	CovidVaccinationService covidVaccinationService;

	@PostMapping("/add")
	public ResponseEntity<CovidVaccination> addCovidCase(@RequestBody CovidVaccination covidVaccination) {
		try {
			CovidVaccination c = covidVaccinationService.insertVaccinPatient(covidVaccination);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update/{idCovidVaccin}")
	public ResponseEntity<CovidVaccination> updateCovidCase(@PathVariable Long idCovidVaccin,
			@RequestBody CovidVaccination covidCase) {
		try {
			return new ResponseEntity<>(covidVaccinationService.updateVaccinCase(idCovidVaccin, covidCase),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/first/perDay/{country}")
	public ResponseEntity<?> getFirstVaccinationPerDay(@PathVariable String country) {
		List<VaccinationCasesPerPeriod> list = covidVaccinationService.findFirstVaccinationCasesPerDay(country);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping("/second/perDay/{country}")
	public ResponseEntity<?> getSecondVaccinationPerDay(@PathVariable String country) {
		List<VaccinationCasesPerPeriod> list = covidVaccinationService.findSecondVaccinationCasesPerDay(country);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping("/first/perYear/{country}")
	public ResponseEntity<?> getFirstVaccinationPerYear(@PathVariable String country) {
		List<VaccinationCasesPerPeriod> list = covidVaccinationService.findFirstVaccinationPerYear(country);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/second/perYear/{country}")
	public ResponseEntity<?> getSecondVaccinationPerYear(@PathVariable String country) {
		List<VaccinationCasesPerPeriod> list = covidVaccinationService.findSecondVaccinationPerYear(country);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/first/perMonth/{country}")
	public ResponseEntity<?> getFirstVaccinationPerMonth(@PathVariable String country) {
		List<VaccinationCasesPerPeriod> list = covidVaccinationService.findFirstVaccinationPerMonth(country);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/second/perMonth/{country}")
	public ResponseEntity<?> getSecondVaccinationPerMonth(@PathVariable String country) {
		List<VaccinationCasesPerPeriod> list = covidVaccinationService.findSecondVaccinationPerMonth(country);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
