package com.fourtkb.appointmentservice.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name="appointment")
public class AppointmentEntity {

    @Id
    @Column(name = "appointment_id", nullable = false)
    private String appointmentId;
    private String location;
    @Column(name = "patient_id", nullable = false)
    private String patientId;
    @Column(name = "professional_name", nullable = false)
    private String professionalName;
    @Column(name = "datetime", nullable = false)
    private LocalDateTime date;

    @CreationTimestamp
    LocalDateTime createdAt;

}
