package com.fourtkb.appointmentservice.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Appointment {

    private String appointmentId;
    private String location;
    private String patientId;
    private String professionalName;
    private LocalDateTime date;
    LocalDateTime createdAt;
    private String patientName;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
}
