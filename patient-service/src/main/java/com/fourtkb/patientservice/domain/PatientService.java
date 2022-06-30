package com.fourtkb.patientservice.domain;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> getAll();
    Optional<Patient> findById(String id);
    Patient savePatient(Patient patient);
}

