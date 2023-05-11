package com.example.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.stream.IntStream;
import com.example.data.User;
import com.example.repository.UserRepository;
import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class RandomUserRepository implements UserRepository {

    @Override
    public Multi<User> getUsers() {
        var users = new ArrayList<User>();
        IntStream.range(0, 100)
                .forEach(value -> users.add(new User("User " + value, "avatar url")));
        return Multi.createFrom().items(users.stream());
    }
}
