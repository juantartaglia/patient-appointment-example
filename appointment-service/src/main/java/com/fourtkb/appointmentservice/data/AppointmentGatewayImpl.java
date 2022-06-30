package com.fourtkb.appointmentservice.data;

import com.fourtkb.appointmentservice.domain.Appointment;
import com.fourtkb.appointmentservice.domain.gateway.AppointmentGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AppointmentGatewayImpl implements AppointmentGateway {

    AppointmentRepository appointmentRepository;



    @Override
    public Optional<Appointment> findById(String appointmentId) {
        return appointmentRepository.findById(appointmentId).map(this::toAppointment);

    }

    @Override
    public List<Appointment> getAllByPatientId(String patientId) {
        return appointmentRepository.findAllByPatientId(patientId).stream().map(this::toAppointment).collect(Collectors.toList());
    }

    @Override
    public Appointment save(Appointment appointment) {
        return toAppointment(appointmentRepository.save(toAppointmentEntity(appointment)));
    }

    private Appointment toAppointment(AppointmentEntity appointmentEntity) {
        return Appointment.builder()
                        .appointmentId(appointmentEntity.getAppointmentId())
                        .location(appointmentEntity.getLocation())
                        .patientId(appointmentEntity.getPatientId())
                        .professionalName(appointmentEntity.getProfessionalName())
                        .date(appointmentEntity.getDate())
                        .createdAt(appointmentEntity.getCreatedAt())
                        .build();
    }

    private AppointmentEntity toAppointmentEntity(Appointment appointment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setAppointmentId(appointment.getAppointmentId());
        appointmentEntity.setLocation(appointment.getLocation());
        appointmentEntity.setPatientId(appointment.getPatientId());
        appointmentEntity.setProfessionalName(appointment.getProfessionalName());
        appointmentEntity.setDate(appointment.getDate());
        appointmentEntity.setCreatedAt(appointment.getCreatedAt());

        return appointmentEntity;
    }
}
