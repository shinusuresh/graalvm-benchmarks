package com.example.repository.impl;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import com.example.data.User;
import com.example.repository.UserRepository;
import reactor.core.publisher.Flux;

@Singleton
public class RandomUserImpl implements UserRepository {

    @Override
    public Flux<User> getUsers() {
        var users = new ArrayList<User>();
        IntStream.range(0, 100)
                .forEach(value -> users.add(new User("User " + value, "avatar url")));
        return Flux.fromIterable(users);
    }
}
