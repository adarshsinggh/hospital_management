package com.astrotalk.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.astrotalk.dao.PatientRepository;
import com.astrotalk.model.Patient;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public ResponseEntity<String> saveAdmitPatient(Patient patient){
		if(isRoomOccupied(patient.getRoom())) {
			return ResponseEntity.ok("roomOccupied");
		}else {
			patient.setStatus("admitted");
			patient.setAdmitDate(new Date());
			Patient save = patientRepository.save(patient);
			if(save !=null) {
				return ResponseEntity.ok("success");
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed");
			}
		}
	}
	
	public boolean isRoomOccupied(String roomNumber) {
		return patientRepository.existsByRoomAndStatus(roomNumber, "admitted");
	}
	
	public ResponseEntity<List<Patient>> getAdmittedPatient(){
		return ResponseEntity.ok(patientRepository.findByStatus("admitted"));
	}
	
	public ResponseEntity<String> dischargePatient(int patientId){
		Optional<Patient> findById =  patientRepository.findById(patientId);
		if(patientRepository.existsByIdAndStatus(patientId, "discharged")) {
			return ResponseEntity.ok("alreadyDischarged");
		}else if(findById.isPresent()) {
			Patient patient = findById.get();
			patient.setStatus("discharged");
			patientRepository.save(patient);
			return ResponseEntity.ok("success");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
