package com.example.data;

import io.micronaut.core.annotation.ReflectiveAccess;

@ReflectiveAccess
public record User(String name, String avatar) {
}
