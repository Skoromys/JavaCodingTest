package com.example.javacodingtest.controller;

import com.example.javacodingtest.dto.Appointment;
import com.example.javacodingtest.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    @RequestMapping(value = "/appointment",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Appointment addEmployee(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @RequestMapping(value = "/appointment/{id}/newdate/{newDate}",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Appointment addEmployee(@PathVariable("id") String id,
                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") @PathVariable("newDate")
                                           LocalDateTime newDate) {
        return appointmentService.changeDate(id, newDate);
    }


    @RequestMapping(value = "/appointment/{id}",
            method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable("id") String id) {

        appointmentService.removeAppointment(id);
    }
}
