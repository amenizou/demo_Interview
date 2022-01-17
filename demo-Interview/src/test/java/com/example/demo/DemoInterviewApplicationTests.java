package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.covid.demo.DemoInterviewApplication;
import com.covid.demo.entities.Country;
import com.covid.demo.entities.Patient;
import com.covid.demo.service.PatientService;

@SpringBootTest(classes = DemoInterviewApplication.class)
@SpringBootConfiguration
class DemoInterviewApplicationTests {

	@Test
	void contextLoads() {
	}
//	@MockBean
//	private  CovidCaseService covidCaseService;
		
	@MockBean
	//@Autowired
	private PatientService patientService;
	
		
	@Test
	 void addPatientTest()
	{
		String date = "06-08-1996";
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Country country = new Country("TN","TUNISIA");
		Patient patient = new Patient(Long.valueOf(0011223344),"Zouaoui","Ameni",LocalDate.parse(date, df),"TUNIS",country);
		
		
		Patient p = patientService.insert(patient);
		//assertEquals(p,patient);
		
	    when(p.equals(patient)).thenReturn(true);

	}

	@Test
	 void getPatientByIdTest()
	{
//		Country country = new Country("TN","TUNISIA");
//		Patient patient = new Patient(Long.valueOf(0011223344),"Zouaoui","Ameni",LocalDate.parse("06-08-1996"),"TUNIS",country);
//		
		Country country = new Country("TN","TUNISIA");
		Patient patient = new Patient(Long.valueOf(0011223344),"Zouaoui","Ameni",LocalDate.parse("06-08-1996"),"TUNIS",country);
		Optional<Patient> p = patientService.findById(Long.valueOf(0011223344));
		//when(p.isPresent()).thenReturn(true);
		assertEquals(p,patient);

	}
}
