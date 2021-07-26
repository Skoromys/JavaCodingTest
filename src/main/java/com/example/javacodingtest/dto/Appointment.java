package com.example.javacodingtest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class Appointment {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String appointmentId = UUID.randomUUID().toString();
    @JsonProperty("userName")
    private String user;
    @JsonProperty("companyName")
    private String workshop;
    private Trademark trademark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;
}
