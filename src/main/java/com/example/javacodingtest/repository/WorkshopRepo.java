package com.example.javacodingtest.repository;

import com.example.javacodingtest.dto.Workshop;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class WorkshopRepo {
    private static final Map<String, Workshop> map = new HashMap<>();

    public Workshop save(Workshop workshop) {
        map.put(workshop.getCompanyName(), workshop);
        return map.get(workshop.getCompanyName());
    }

    public Workshop getById(String CompanyName) {
        return map.get(CompanyName);
    }

    public void deleteById(String CompanyName) {
        map.remove(CompanyName);
    }

    public List<Workshop> findAllByCity(String city) {
        return map.values().stream()
                .filter(workshop -> workshop.getCity().equals(city))
                .collect(Collectors.toList());
    }
}
