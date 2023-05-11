package com.example.repository;

import java.util.List;
import com.example.data.User;
import reactor.core.publisher.Flux;

public interface UserRepository {

    Flux<User> getUsers();
}
