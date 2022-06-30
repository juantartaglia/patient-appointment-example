package com.fourtkb.appointmentservice.web.dto;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class AppointmentDTO {

    private String appointmentId;

    @NotNull(message = "Code could not be null")
    @NotBlank(message = "Code could not be empty")
    private String location;

    @NotNull(message = "Code could not be null")
    @NotBlank(message = "Code could not be empty")
    private String patientId;

    @NotNull(message = "Code could not be null")
    @NotBlank(message = "Code could not be empty")
    private String professionalName;

    @FutureOrPresent
    private LocalDateTime date;

    private String patientName;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
}
