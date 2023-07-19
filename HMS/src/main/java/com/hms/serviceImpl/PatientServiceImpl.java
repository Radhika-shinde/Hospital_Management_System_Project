package com.hms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entity.Patient;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repositories.PatientRepository;
import com.hms.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	  private final PatientRepository patientRepository;

	    @Autowired
	    public PatientServiceImpl(PatientRepository patientRepository) {
	        this.patientRepository = patientRepository;
	    }

	    @Override
	    public List<Patient> getAllPatients() {
	        return patientRepository.findAll();
	    }

	    @Override
	    public Patient getPatientById(Long id) {
	        Patient patient = patientRepository.findById(id).orElse(null);
	        if (patient == null) {
	            throw new ResourceNotFoundException("Patient not found with ID: " + id);
	        }
	        return patient;
	    }

	    @Override
	    public Patient createPatient(Patient patient) {
	        return patientRepository.save(patient);
	    }

	    @Override
	    public Patient updatePatient(Long id, Patient patient) {
	    	
	        Patient existingPatient = patientRepository.findById(id).orElse(null);
	        if (existingPatient == null) {
	            throw new ResourceNotFoundException("Patient not found with ID: " + id);
	        }
	        patient.setId(id);
	        return patientRepository.save(patient);

	    }

	    @Override
	    public void deletePatient(Long id) {
	        patientRepository.deleteById(id);
	    }

}
