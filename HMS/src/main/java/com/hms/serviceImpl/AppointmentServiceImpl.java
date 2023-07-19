package com.hms.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dto.AppointmentDTO;
import com.hms.entity.Appointment;
import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.repositories.AppointmentRepository;
import com.hms.repositories.DoctorRepository;
import com.hms.repositories.PatientRepository;
import com.hms.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    
    @Autowired
    DoctorRepository docRepository;

    @Autowired
    PatientRepository pRepository;
    
    @Override
    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        return appointmentOptional.map(this::convertToDto).orElse(null);
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO, long patientId, String doctorName) {
        Appointment appointment = convertToEntity(appointmentDTO);
        Patient patient = pRepository.findById(patientId).get();
        Doctor doctor = docRepository.findByName(doctorName);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return convertToDto(savedAppointment);
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            appointment.setPatient(appointmentDTO.getPatient());
            appointment.setDoctor(appointmentDTO.getDoctor());
            appointment.setDateTime(appointmentDTO.getDateTime());
           
            Appointment updatedAppointment = appointmentRepository.save(appointment);
            return convertToDto(updatedAppointment);
        }
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    private AppointmentDTO convertToDto(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setPatient(appointment.getPatient());
        appointmentDTO.setDoctor(appointment.getDoctor());
        appointmentDTO.setDateTime(appointment.getDateTime());
        
        return appointmentDTO;
    }

    private Appointment convertToEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setDoctor(appointmentDTO.getDoctor());
        appointment.setDateTime(appointmentDTO.getDateTime());
    
        return appointment;
    }
	

}
