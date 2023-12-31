package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>{

	Doctor findByName(String docName);
}
