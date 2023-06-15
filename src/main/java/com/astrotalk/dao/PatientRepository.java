package com.astrotalk.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.astrotalk.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
	
	public boolean existsByRoomAndStatus(String roomNumber,String status);
	
	public List<Patient> findByStatus(String status);
	
	public boolean existsByIdAndStatus(int patientId, String status);
}
