package com.example.javacodingtest.repository;

import com.example.javacodingtest.dto.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class UserRepo {
    private static final Map<String, User> USERS = new HashMap<>();
    private static final Set<String> EMAILS = new HashSet<>();

    public User save(User user) {
        if (EMAILS.contains(user.getEmail())) {
            throw new IllegalArgumentException("Email <" + user.getEmail() + "> has already been taken.");
        }

        USERS.put(user.getUserName(), user);
        EMAILS.add(user.getEmail());

        return USERS.get(user.getUserName());
    }

    public void deleteById(String userName) {
        User removed = USERS.remove(userName);
        EMAILS.remove(removed.getEmail());
    }
}
