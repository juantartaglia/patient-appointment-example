package com.fourtkb.appointmentservice.domain.gateway;

import com.fourtkb.appointmentservice.domain.Patient;

import java.util.Optional;

public interface PatientGateway {
    Optional<Patient> findById(String patientId);
}
