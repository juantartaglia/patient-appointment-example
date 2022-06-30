package com.fourtkb.patientservice.data;

import com.fourtkb.patientservice.domain.Patient;
import com.fourtkb.patientservice.domain.gateway.PatientGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
public class PatientGatewayImpl implements PatientGateway {

    private final PatientRepository patientRepository;

    public PatientGatewayImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll().stream()
                .map(this::toPatient)
                .collect(toList());
    }

    @Override
    public Optional<Patient> findById(String id) {
        return patientRepository.findById(id).map(this::toPatient);
    }


    @Override
    public Patient savePatient(Patient patient) {
        PatientEntity patientEntity = toPatientEntity(patient);
        patientRepository.save(patientEntity);
        return toPatient(patientEntity);
    }

    private Patient toPatient(PatientEntity patientEntity) {
        return Patient.builder()
                .id(patientEntity.getId())
                .name(patientEntity.getName())
                .contactName(patientEntity.getContactName())
                .contactEmail(patientEntity.getContactEmail())
                .contactPhone(patientEntity.getContactPhone())
                .active(patientEntity.isActive())
                .createdAt(patientEntity.getCreatedAt())
                .lastUpdatedAt(patientEntity.getLastUpdatedAt())
                .build();
    }

    private PatientEntity toPatientEntity(Patient patient) {
        PatientEntity patientEntity = new PatientEntity();
                patientEntity.setId(patient.getId());
                patientEntity.setName(patient.getName());
                patientEntity.setContactName(patient.getContactName());
                patientEntity.setContactEmail(patient.getContactEmail());
                patientEntity.setContactPhone(patient.getContactPhone());
                patientEntity.setActive(patient.isActive());
                patientEntity.setCreatedAt(patient.getCreatedAt());
                patientEntity.setLastUpdatedAt(patient.getLastUpdatedAt());
        return patientEntity;
    }

}
