package com.hms.dto;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hms.entity.Doctor;
import com.hms.entity.Patient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class AppointmentDTO {

	
	
	    private Long id;
	
		private LocalDateTime dateTime;
		
	    @ManyToOne
        @JoinColumn(name = "patient_id")
	    private Patient patient;
	    @ManyToOne
	    @JoinColumn(name="doctor_id")
	    private Doctor doctor;
	   


}
