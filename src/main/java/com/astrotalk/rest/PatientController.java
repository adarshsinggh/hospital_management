package com.astrotalk.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrotalk.model.Patient;
import com.astrotalk.service.PatientService;

@RestController
@RequestMapping("/rest/operations")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping(path = "/admitPatient")
	public ResponseEntity<String> admitPatient(@RequestBody Patient patient){
		return patientService.saveAdmitPatient(patient);
	} 
	
	@GetMapping(path = "/getAdmittedPatients")
	public ResponseEntity<List<Patient>> getAdmittedPatients(){
		return patientService.getAdmittedPatient();
	}
	
	@PostMapping("dischargePatient/{patientId}")
	public ResponseEntity<String> dischargePatient(@PathVariable int patientId){
		return patientService.dischargePatient(patientId);
	}

}
