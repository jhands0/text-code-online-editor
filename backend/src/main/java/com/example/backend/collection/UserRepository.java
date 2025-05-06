package com.example.backend.collection;

import com.example.backend.models.User;

public interface UserRepository {
    User findById(String id);
}
