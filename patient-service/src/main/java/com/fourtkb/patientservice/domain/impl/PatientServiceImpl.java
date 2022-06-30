package com.fourtkb.patientservice.domain.impl;

import com.fourtkb.patientservice.domain.Patient;
import com.fourtkb.patientservice.domain.PatientService;
import com.fourtkb.patientservice.domain.gateway.PatientGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientGateway patientGateway;

    public PatientServiceImpl(PatientGateway patientGateway) {
        this.patientGateway = patientGateway;
    }


    @Override
    public List<Patient> getAll() {
        return patientGateway.getAll();
    }

    @Override
    public Optional<Patient> findById(String id) {
        return patientGateway.findById(id);
    }

    @Override
    public Patient savePatient(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        return patientGateway.savePatient(patient);
    }

}
