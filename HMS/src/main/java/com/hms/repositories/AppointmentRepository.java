package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{

}
