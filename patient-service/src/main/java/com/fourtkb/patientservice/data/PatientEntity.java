package com.fourtkb.patientservice.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PatientEntity {

    @Id
    String id;
    @NotBlank
    String name;
    String contactName;
    @NotBlank
    String contactEmail;
    String contactPhone;
    boolean active = true;
    @CreationTimestamp
    LocalDateTime createdAt;
    LocalDateTime lastUpdatedAt;
}