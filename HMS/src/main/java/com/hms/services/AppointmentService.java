package com.hms.services;

import java.util.List;

import com.hms.dto.AppointmentDTO;

public interface AppointmentService {
	
	List<AppointmentDTO> getAllAppointments();

    AppointmentDTO getAppointmentById(Long id);

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO, long patientId, String doctorName);

    AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO);

    void deleteAppointment(Long id);

}
