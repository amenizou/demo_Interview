package com.covid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.covid.demo.entities.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient , Long>{

}
