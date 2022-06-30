package com.fourtkb.patientservice.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
@Builder
public class PatientDTO extends RepresentationModel<PatientDTO> {

        String id;

        @NotNull(message = "Code could not be null")
        @NotBlank(message = "Code could not be empty")
        String name;
        String contactName;

        @NotNull(message = "Code could not be null")
        @NotBlank(message = "Code could not be empty")
        String contactEmail;
        String contactPhone;
        boolean active;
        LocalDateTime createdAt;
        LocalDateTime lastUpdatedAt;
}
