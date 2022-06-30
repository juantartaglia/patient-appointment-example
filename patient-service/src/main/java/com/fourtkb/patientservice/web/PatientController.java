package com.fourtkb.patientservice.web;

import com.fourtkb.patientservice.domain.Patient;
import com.fourtkb.patientservice.domain.PatientService;
import com.fourtkb.patientservice.web.dto.PatientDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    ResponseEntity<List<PatientDTO>> getAllPatient() {
        return new ResponseEntity<List<PatientDTO>>(patientService.getAll().stream().map(this::toPatientDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<PatientDTO> findPatientById(@PathVariable("id") String id) {
        return patientService.findById(id)
                            .map(e -> new ResponseEntity<PatientDTO>(toPatientDTO(e), HttpStatus.OK))
                            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    ResponseEntity<PatientDTO> savePatient(@RequestBody @Valid PatientDTO patientDTO) {

        Patient patient = patientService.savePatient(toPatient(patientDTO));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(getURIResourceLocation(patient));
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(toPatientDTO(patient));
    }

    PatientDTO toPatientDTO(Patient patient) {

        return  PatientDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .contactName(patient.getContactName())
                .contactEmail(patient.getContactEmail())
                .contactPhone(patient.getContactPhone())
                .active(patient.isActive())
                .createdAt(patient.getCreatedAt())
                .lastUpdatedAt(patient.getLastUpdatedAt())
                .build();
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

    private URI getURIResourceLocation(Patient patient) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patient.getId())
                .toUri();
    }
}
