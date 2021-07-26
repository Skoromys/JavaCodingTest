package com.example.javacodingtest.service;

import com.example.javacodingtest.dto.User;

public interface UserService {

    User createUser(User user);

    void removeUser(String userName);
}
