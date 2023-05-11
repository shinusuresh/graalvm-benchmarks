package com.example.repository;

import com.example.data.User;
import io.smallrye.mutiny.Multi;

public interface UserRepository {

    Multi<User> getUsers();
}
