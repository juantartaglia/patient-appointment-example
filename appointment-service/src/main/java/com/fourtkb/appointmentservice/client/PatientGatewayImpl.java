package com.fourtkb.appointmentservice.client;

import com.fourtkb.appointmentservice.client.dto.PatientDTO;
import com.fourtkb.appointmentservice.domain.Patient;
import com.fourtkb.appointmentservice.domain.gateway.PatientGateway;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PatientGatewayImpl  implements PatientGateway {

    PatientFeignClient patientFeignClient;

    public PatientGatewayImpl(PatientFeignClient patientFeignClient) {
        this.patientFeignClient = patientFeignClient;
    }

    @Override
    public Optional<Patient> findById(String patientId) {
        return Optional.of(patientFeignClient.getPatientDTOById(patientId)).map(this::toPatient);
    }

    Patient toPatient(PatientDTO patientDTO) {
        return Patient.builder()
                .id(patientDTO.getId())
                .name(patientDTO.getName())
                .contactName(patientDTO.getContactName())
                .contactEmail(patientDTO.getContactEmail())
                .contactPhone(patientDTO.getContactPhone())
                .active(patientDTO.isActive())
                .createdAt(patientDTO.getCreatedAt())
                .lastUpdatedAt(patientDTO.getLastUpdatedAt())
                .build();

    }
}
