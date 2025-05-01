package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class SignupController {

    @GetMapping("/api/signup")
    public List<User> getUser() {
        return Arrays.asList(new User("name1", "email1", "pfp"), new User("name2", "email2", "pfp"));
    }

}
