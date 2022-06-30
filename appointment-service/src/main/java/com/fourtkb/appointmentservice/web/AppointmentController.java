package com.fourtkb.appointmentservice.web;

import com.fourtkb.appointmentservice.domain.Appointment;
import com.fourtkb.appointmentservice.domain.AppointmentService;
import com.fourtkb.appointmentservice.web.dto.AppointmentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> newAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentService.newAppointment(toAppointment(appointmentDTO));
        return new ResponseEntity<>(toAppointmentDTO(appointmentService.newAppointment(appointment)), HttpStatus.CREATED);
    }



    private AppointmentDTO toAppointmentDTO(Appointment appointment) {
        return AppointmentDTO.builder()
                .appointmentId(appointment.getAppointmentId())
                .location(appointment.getLocation())
                .patientId(appointment.getPatientId())
                .professionalName(appointment.getProfessionalName())
                .date(appointment.getDate())
                .contactEmail(appointment.getContactEmail())
                .contactName(appointment.getContactName())
                .contactPhone(appointment.getContactPhone())
                .patientName(appointment.getPatientName())
                .build();
    }

    private Appointment toAppointment(AppointmentDTO appointmentDTO) {
        return Appointment.builder()
                .appointmentId(appointmentDTO.getAppointmentId())
                .location(appointmentDTO.getLocation())
                .patientId(appointmentDTO.getPatientId())
                .professionalName(appointmentDTO.getProfessionalName())
                .date(appointmentDTO.getDate())
                .build();
    }

    /*
    @PostMapping
    public ResponseEntity<InputDTO> newInput(@Valid @RequestBody InputDTO inputDTO) {
        Input input = inputService.createInput(toInput(inputDTO));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(getURIResourceLocation(input));

    return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(new ModelMapper().map(input, InputDTO.class));
    }
     */
}
