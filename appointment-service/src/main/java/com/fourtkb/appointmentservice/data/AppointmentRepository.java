package com.fourtkb.appointmentservice.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, String> {

    List<AppointmentEntity> findAllByPatientId(String patientId);
}
