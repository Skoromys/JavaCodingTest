package com.example.javacodingtest.service;

import com.example.javacodingtest.dto.User;
import com.example.javacodingtest.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final AppointmentService appointmentService;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void removeUser(String userName) {
        if(isAppointmentExists(userName)){
            throw new IllegalArgumentException("Couldn't remove user <" + userName + "> : an appointment exists.");
        }

        userRepo.deleteById(userName);
    }

    private boolean isAppointmentExists(String userName) {
        return appointmentService.getAll().stream()
                .anyMatch(a -> a.getUser().equals(userName));
    }
}
