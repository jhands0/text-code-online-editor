package com.example.backend.collection;

import com.example.backend.models.User;

public interface UserRepository {
    User findById(String id);

    User save(User user);

    User update(String id, User user);
}
