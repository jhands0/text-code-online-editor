package com.example.backend.service;

import com.example.backend.entity.User;

public interface SignupService {
    User getUserByEmail(String email);
    User createUser(User user);

    User updateUser(String email, User user);
}
