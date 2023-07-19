package com.hms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="appointments")
public class Appointment {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private LocalDateTime DateTime;
	    @ManyToOne
	    @JoinColumn(name="patient_id")
	    private  Patient patient;
	    @ManyToOne
	    @JoinColumn(name="doctor_id")
	    private Doctor doctor;
	    
	   


}
