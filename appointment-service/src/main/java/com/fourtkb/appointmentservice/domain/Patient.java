package com.fourtkb.appointmentservice.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Builder
public class Patient{

    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime lastUpdatedAt;
}
