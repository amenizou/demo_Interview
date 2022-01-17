package com.covid.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.covid.demo.entities.Patient;
import com.covid.demo.repository.PatientRepository;
import com.covid.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	
	
	public Patient insert(Patient patient) {
		return patientRepository.save(patient);
	}
	
	@Override
    public List<Patient> findAll() {
        return patientRepository.findAll();

    }
	
	 public Page<Patient> findPatientsWithPagination(int offset,int pageSize) {
		 Page<Patient> patients = patientRepository.findAll(PageRequest.of(offset, pageSize));
	        return patients;
	    }
	
	

	@Override
	public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
	}
	
}
