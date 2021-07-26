package com.example.javacodingtest.service;

import com.example.javacodingtest.dto.Appointment;
import com.example.javacodingtest.repository.AppointmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepo appointmentRepo;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public void removeAppointment(String appointmentId) {
        appointmentRepo.deleteById(appointmentId);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment changeDate(String appointmentId, LocalDateTime newDate) {
        Appointment appointment = appointmentRepo.getById(appointmentId);
        if (appointment != null) {
            appointment.setDateTime(newDate);
            return appointmentRepo.save(appointment);
        }

        throw new IllegalArgumentException("Couldn't find an appointment wit id " + appointmentId);
    }
}
