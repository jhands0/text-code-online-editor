package com.example.backend.routes;

import org.springframework.stereotype.Service;

public interface SignupService {
    User getUserByEmail(String email);
}
@Service
public class SignupServiceImpl {
    private final UserRepository userRepository;

    public SignupServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findById(email);
    }
}
