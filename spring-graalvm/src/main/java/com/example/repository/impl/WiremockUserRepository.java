package com.example.repository.impl;

import com.example.data.User;
import com.example.repository.UserRepository;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;

@HttpExchange(url = "/users", accept = "application/json", contentType = "application/json")
public interface WiremockUserRepository extends UserRepository {

    @GetExchange
    Flux<User> getUsers();
}
