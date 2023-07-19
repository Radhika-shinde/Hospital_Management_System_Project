package com.hms.services;

import java.util.List;

import com.hms.dto.DoctorDTO;

public interface DoctorService {
	    List<DoctorDTO> getAllDoctors();
	    
	    DoctorDTO getDoctorById(Long id);
	    
	    DoctorDTO createDoctor(DoctorDTO doctorDTO);
	    
	    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);
	    
	    void deleteDoctor(Long id);

}
