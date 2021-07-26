package com.example.javacodingtest.dto;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String email;
    private String city;
    private String postalCode;
    private String country;
}
