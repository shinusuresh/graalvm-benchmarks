package com.example.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import com.example.data.User;
import com.example.repository.UserRepository;
import io.smallrye.mutiny.Multi;

@Path("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<User> users() {
        return userRepository.getUsers();
    }
}
