package com.example.javacodingtest.repository;

import com.example.javacodingtest.dto.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AppointmentRepo {
    private static final Map<String, Appointment> APPOINTMENT = new HashMap<>();

    public Appointment save(Appointment appointment) {
        APPOINTMENT.put(appointment.getAppointmentId(), appointment);

        return APPOINTMENT.get(appointment.getAppointmentId());
    }

    public Appointment getById(String appointmentId) {
        return APPOINTMENT.get(appointmentId);
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(APPOINTMENT.values());
    }

    public void deleteById(String appointmentId) {
        APPOINTMENT.remove(appointmentId);
    }
}
