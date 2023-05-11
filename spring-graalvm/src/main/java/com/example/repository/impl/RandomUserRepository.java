package com.example.repository.impl;

import java.util.ArrayList;
import java.util.stream.IntStream;
import com.example.data.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class RandomUserRepository implements UserRepository {

    @Override
    public Flux<User> getUsers() {
        var users = new ArrayList<User>();
        IntStream.range(0, 100)
                .forEach(value -> users.add(new User("User " + value, "avatar url")));
        return Flux.fromIterable(users);
    }
}
