package com.example.backend.service;

import com.example.backend.entity.User;

public interface SignupService {
    User getUserById(String id);
    User createUser(User user);

    User updateUser(String id, User user);

    void deleteUser(String id);
}
