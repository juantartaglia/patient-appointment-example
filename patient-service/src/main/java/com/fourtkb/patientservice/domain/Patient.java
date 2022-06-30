package com.fourtkb.patientservice.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Patient {

    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;
    boolean active;
    LocalDateTime createdAt;
    LocalDateTime lastUpdatedAt;
}
