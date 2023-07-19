package com.hms.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dto.DoctorDTO;
import com.hms.entity.Doctor;
import com.hms.repositories.DoctorRepository;
import com.hms.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	private final DoctorRepository doctorRepository;

	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	@Override
	public List<DoctorDTO> getAllDoctors() {
		List<Doctor> doctors = doctorRepository.findAll();
		return doctors.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public DoctorDTO getDoctorById(Long id) {
		Optional<Doctor> doctorOptional = doctorRepository.findById(id);
		return doctorOptional.map(this::convertToDto).orElse(null);
	}

	@Override
	public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
		Doctor doctor = convertToEntity(doctorDTO);
		Doctor savedDoctor = doctorRepository.save(doctor);
		return convertToDto(savedDoctor);
	}

	@Override
	public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
		Optional<Doctor> doctorOptional = doctorRepository.findById(id);
		if (doctorOptional.isPresent()) {
			Doctor doctor = doctorOptional.get();
			doctor.setName(doctorDTO.getName());
			doctor.setSpecialization(doctorDTO.getSpecialization());
			
			Doctor updatedDoctor = doctorRepository.save(doctor);
			return convertToDto(updatedDoctor);
		}
		return null;
	}

	@Override
	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}

	private DoctorDTO convertToDto(Doctor doctor) {
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setId(doctor.getId());
		doctorDTO.setName(doctor.getName());
		doctorDTO.setSpecialization(doctor.getSpecialization());
		
		return doctorDTO;
	}

	private Doctor convertToEntity(DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor();
		doctor.setId(doctorDTO.getId());
		doctor.setName(doctorDTO.getName());
		doctor.setSpecialization(doctorDTO.getSpecialization());
		
		return doctor;
	}
	

}
