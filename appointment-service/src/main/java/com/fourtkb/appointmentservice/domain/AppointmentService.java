package com.fourtkb.appointmentservice.domain;

import org.springframework.context.ApplicationContext;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    Appointment findById(String appointmentId);

    Appointment newAppointment(Appointment appointment);
}
