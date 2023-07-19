package com.hms.services;

import java.util.List;

import com.hms.entity.Patient;

public interface PatientService {
	List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient createPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);

}
