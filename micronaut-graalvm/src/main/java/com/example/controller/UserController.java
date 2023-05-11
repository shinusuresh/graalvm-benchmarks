package com.example.controller;

import com.example.data.User;
import com.example.repository.UserRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Flux;

@Controller("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Get(produces = "application/json")
    public Flux<User> users() {
        return userRepository.getUsers();
    }
}
