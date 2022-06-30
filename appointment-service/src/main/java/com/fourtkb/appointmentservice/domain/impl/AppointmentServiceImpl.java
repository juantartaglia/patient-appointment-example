package com.fourtkb.appointmentservice.domain.impl;

import com.fourtkb.appointmentservice.domain.Appointment;
import com.fourtkb.appointmentservice.domain.AppointmentService;
import com.fourtkb.appointmentservice.domain.Patient;
import com.fourtkb.appointmentservice.domain.gateway.AppointmentGateway;
import com.fourtkb.appointmentservice.domain.gateway.PatientGateway;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    AppointmentGateway appointmentGateway;
    PatientGateway patientGateway;

    public AppointmentServiceImpl(AppointmentGateway appointmentGateway, PatientGateway patientGateway) {
        this.appointmentGateway = appointmentGateway;
        this.patientGateway = patientGateway;
    }

    @Override
    public List<Appointment> getAll() {
        return null;
    }

    @Override
    public Appointment findById(String appointmentId) {
        Optional<Appointment> appointmentOpt = appointmentGateway.findById(appointmentId);
        if (!appointmentOpt.isPresent())
            throw new IllegalArgumentException("Appointment not found");

        Appointment appointment = appointmentOpt.get();
        Optional<Patient> patient = retrievePatient(appointment.getPatientId());
        if (patient.isPresent()) {
            Patient p = patient.get();
            appointment.setPatientName(p.getName());
            appointment.setPatientId(p.getId());
            appointment.setContactName(p.getContactName());
            appointment.setContactPhone(p.getContactPhone());
            appointment.setContactEmail(p.getContactEmail());
        }
        return appointment;
    }

    @Override
    public Appointment newAppointment(Appointment appointment) {
        appointment.setAppointmentId(UUID.randomUUID().toString());
        appointment.setCreatedAt(LocalDateTime.now());
        appointmentGateway.save(appointment);
        return appointment;
    }

    private Optional<Patient> retrievePatient(String patientId) {
        return patientGateway.findById(patientId);
    }


}
