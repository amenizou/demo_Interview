package com.covid.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.covid.demo.entities.Patient;


public interface PatientService {

	public Patient insert(Patient patient);
	public List<Patient> findAll();
	public Optional<Patient> findById(Long id);
	public Page<Patient> findPatientsWithPagination(int offset,int pageSize);
	
}
