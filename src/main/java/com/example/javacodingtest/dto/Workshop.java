package com.example.javacodingtest.dto;

import lombok.Data;

import java.util.List;

@Data
public class Workshop {
    private String companyName;
    private List<Trademark> trademarks;
    private String city;
    private String postalCode;
    private String country;
}
