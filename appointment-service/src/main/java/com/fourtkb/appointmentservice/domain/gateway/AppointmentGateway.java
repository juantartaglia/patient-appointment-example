package com.fourtkb.appointmentservice.domain.gateway;

import com.fourtkb.appointmentservice.domain.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentGateway {

    Optional<Appointment> findById(String appointmentId);

    List<Appointment> getAllByPatientId(String patientId);

    Appointment save(Appointment appointment);

}
