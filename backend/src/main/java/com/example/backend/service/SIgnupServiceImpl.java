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
    public User getUserByEmail(String email) {
        return userRepository.findById(email);
    }

    @Override
    public User createUser(User user) { return userRepository.save(user); }

    @Override
    public User updateUser(String email, User user) { return userRepository.update(email, user); }

    @Override
    public void deleteUser(String email) { userRepository.delete(email); }
}
