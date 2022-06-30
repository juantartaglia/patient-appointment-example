package com.fourtkb.patientservice.domain.gateway;

import com.fourtkb.patientservice.domain.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PatientGateway {

    List<Patient> getAll();
    Optional<Patient> findById(String id);
    Patient savePatient(Patient patient);

}
