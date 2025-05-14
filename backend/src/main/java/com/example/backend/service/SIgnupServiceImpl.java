package com.example.backend.service;

import com.example.backend.entity.User;
import com.example.backend.collection.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {
    private final UserRepository userRepository;

    public SignupServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) { return userRepository.save(user); }

    @Override
    public User updateUser(String id, User user) { return userRepository.update(id, user); }

    @Override
    public void deleteUser(String id) { userRepository.delete(id); }
}
