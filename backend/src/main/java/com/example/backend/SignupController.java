package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class SignupController {

    @GetMapping("/api/signup")
    public List<User> getUser() {
        return Arrays.asList(new User("name1", "email1", "pfp"), new User("name2", "email2", "pfp"));
    }

    @PostMapping("/api/signup")
    public List<user> postUser() {
        return Arrays.asList(new User("name1", "email1", "pfp"), new User("name2", "email2", "pfp"));
    }

    @PutMapping("/api/signup")
    public List<user> putUser() {
        return Arrays.asList(new User("name1", "email1", "pfp"), new User("name2", "email2", "pfp"));
    }

    @DeleteMapping("/api/signup")
    public List<user> deleteUser() {
        return Arrays.asList(new User("name1", "email1", "pfp"), new User("name2", "email2", "pfp"));
    }

}
