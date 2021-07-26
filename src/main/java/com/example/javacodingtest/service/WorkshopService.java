package com.example.javacodingtest.service;

import com.example.javacodingtest.dto.Workshop;

import java.util.List;

public interface WorkshopService {

    Workshop createWorkshop(Workshop workshop);

    void removeWorkshop(String companyName);

    List<Workshop> getAllByCity(String city);
}
