package com.example.backend.controller;

import java.util.List;
import java.util.Arrays;

import com.example.backend.service.SignupService;
import com.example.backend.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/signup")
public class SignupController {

    private static final Logger log = LoggerFactory.getLogger(SignupController.class);
    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @GetMapping("/{email}")
    @Operation(summary = "Get a user by unique email address")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        try {
            User user = signupService.getUserByEmail(email);
            if (email != null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                log.error("Document Not Found: " + email);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{email}")
    @Operation(summary = "Create a user with unique email address")
    public ResponseEntity<User> createUser(@PathVariable String email, @Valid @RequestBody User user) {
        try {
            User newUser = signupService.createUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{email}")
    @Operation(summary = "Update a user's data")
    public ResponseEntity<user> updateUser(@PathVariable String email, @Valid @RequestBody User user) {
        try {
            User updatedUser = signupService.updateUser(email, user);
            if (updatedUser != null) {
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/api/signup")
    public List<user> deleteUser() {
        return Arrays.asList(new User("name1", "email1", "pfp"), new User("name2", "email2", "pfp"));
    }

}
