package com.covid.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.demo.entities.Patient;
import com.covid.demo.service.PatientService;


@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	PatientService patientService;

	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
	    return patientService.insert(patient);
	  }

		@GetMapping("/")
		public ResponseEntity<List<Patient>> getAllPatients() {
			
			try {
				
				List<Patient> patients = new ArrayList<Patient>();
				patientService.findAll().forEach(patients::add);
				if (patients.isEmpty()) {
					
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					
				}
				return new ResponseEntity<>(patients, HttpStatus.OK);
			
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		
		
		
		
		@GetMapping("/pagination/{offset}/{pageSize}")
		public ResponseEntity<Page<Patient>> getAllPatientsPagination(@PathVariable int offset, @PathVariable int pageSize) {
			
			try {
				
				Page<Patient> patients = patientService.findPatientsWithPagination(offset,pageSize);
				
				return new ResponseEntity<>(patients, HttpStatus.OK);
			
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		
		
		
		
		
 
	 @GetMapping("/{idPatient}")
	 public ResponseEntity<Patient> findPatientById(@PathVariable(value = "idPatient") long idPatient) {
	     Optional<Patient> patient = patientService.findById(idPatient);
	     if (patient.isPresent()) {
	       return new ResponseEntity<>(patient.get(), HttpStatus.OK);
	     } else {
	       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }

	public PatientController() {
		super();
	}
	 
	 
	 
	 
}
