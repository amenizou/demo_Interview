/**
 * 
 */
package com.covid.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.demo.DTO.CovidCasesPerPeriod;
import com.covid.demo.entities.CovidCase;
import com.covid.demo.service.CovidCaseService;

/**
 * @author ameni.zouaoui
 *
 */
@RestController
@RequestMapping("/api/covid")
@CrossOrigin("*")
public class CovidCaseController {

	@Autowired
	CovidCaseService covidCaseService;

	@PostMapping("/add")
	 public ResponseEntity<CovidCase> addCovidCase(@RequestBody CovidCase covidCase) {			
		try {
		      return new ResponseEntity<>(covidCaseService.insertCovidPatient(covidCase), HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	
	@PutMapping("/update/{idCovidCase}")
	 public ResponseEntity<CovidCase> updateCovidCase(@PathVariable Long idCovidCase,@RequestBody CovidCase covidCase) {			
		try {
			  return new ResponseEntity<>(covidCaseService.updateCovidCase(idCovidCase,covidCase), HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	
		@GetMapping("/total/perDay/{country}/{testResult}")
		public ResponseEntity<?> getAllCovidCasesPerDay(@PathVariable String country,
				@PathVariable boolean testResult) {
			List<CovidCasesPerPeriod> list = covidCaseService.findCovidCasesPerDay(country, testResult);
			return new ResponseEntity<>(list, HttpStatus.OK);

		}

		@GetMapping("/total/perYear/{country}/{testResult}/{year}")
		public ResponseEntity<?> getAllCovidCasesPerYear(@PathVariable String country,
				@PathVariable boolean testResult,Integer year) {
			List<CovidCasesPerPeriod> list = covidCaseService.findCovidCasesPerYear(country, testResult);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}

		@GetMapping("/total/perMonth/{country}/{testResult}/{year}")
		public ResponseEntity<?> getAllCovidCasesPerMonth(@PathVariable String country,
				@PathVariable boolean testResult,Integer year) {
			List<CovidCasesPerPeriod> list = covidCaseService.findCovidCasesPerMonth(country, testResult);
			return new ResponseEntity<>(list, HttpStatus.OK);

}
	
	
	
}
