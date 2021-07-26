package com.example.javacodingtest.service;

import com.example.javacodingtest.dto.Appointment;
import com.example.javacodingtest.dto.Trademark;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    void removeAppointment(String AppointmentName);

    List<Appointment> getAll();

    Appointment changeDate(String appointmentId, LocalDateTime newDate);
}
