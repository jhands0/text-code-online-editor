package com.example.backend.service;

import com.example.backend.entity.User;

public abstract interface SignupService {
    User getUserByEmail(String email);
    User createUser(User user);
}
