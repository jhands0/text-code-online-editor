package com.example.backend.collection;

import com.example.backend.entity.User;

public interface UserRepository {
    User findById(String id);

    User save(User user);

    User update(String id, User user);
}
