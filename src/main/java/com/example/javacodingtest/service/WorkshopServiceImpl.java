package com.example.javacodingtest.service;

import com.example.javacodingtest.dto.Workshop;
import com.example.javacodingtest.repository.WorkshopRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepo workshopRepo;
    private final AppointmentService appointmentService;

    @Override
    public Workshop createWorkshop(Workshop workshop) {
        return workshopRepo.save(workshop);
    }

    @Override
    public void removeWorkshop(String companyName) {
        if (isAppointmentExists(companyName)) {
            throw new IllegalArgumentException("Couldn't remove workshop <" + companyName + ">: an appointment exists.");
        }
        workshopRepo.deleteById(companyName);
    }

    @Override
    public List<Workshop> getAllByCity(String city) {
        return workshopRepo.findAllByCity(city);
    }

    private boolean isAppointmentExists(String companyName) {
        return appointmentService.getAll().stream()
                .anyMatch(a -> a.getWorkshop().equals(companyName));
    }
}
