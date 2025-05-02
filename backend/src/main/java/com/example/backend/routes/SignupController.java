package com.example.backend.routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("api/signup")
public class SignupController {
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
            return new ResponseEntity<>(HttpStatus.Internal_SERVER_ERROR);
        }
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
