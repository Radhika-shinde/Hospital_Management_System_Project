package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dto.DoctorDTO;

import com.hms.services.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	  private final DoctorService doctorService;

	    @Autowired
	    public DoctorController(DoctorService doctorService) {
	        this.doctorService = doctorService;
	    }

	    @GetMapping
	    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
	        List<DoctorDTO> doctors = doctorService.getAllDoctors();
	        return new ResponseEntity<>(doctors, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
	        DoctorDTO doctor = doctorService.getDoctorById(id);
	        if (doctor != null) {
	            return new ResponseEntity<>(doctor, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
	        DoctorDTO createdDoctor = doctorService.createDoctor(doctorDTO);
	        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
	        DoctorDTO updatedDoctor = doctorService.updateDoctor(id, doctorDTO);
	        if (updatedDoctor != null) {
	            return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
	        doctorService.deleteDoctor(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	

}




