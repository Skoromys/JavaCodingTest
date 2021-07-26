package com.example.javacodingtest.controller;

import com.example.javacodingtest.dto.User;
import com.example.javacodingtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/user",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public User addEmployee(@RequestBody User user) {
        try {
            return userService.createUser(user);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    @RequestMapping(value = "/user/{name}",
            method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable("name") String userName) {

        userService.removeUser(userName);
    }
}
