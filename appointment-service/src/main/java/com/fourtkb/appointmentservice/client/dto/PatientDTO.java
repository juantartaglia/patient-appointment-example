package com.fourtkb.appointmentservice.client.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PatientDTO {

    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime lastUpdatedAt;
}
