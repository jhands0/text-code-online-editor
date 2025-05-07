package com.example.backend.entity;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String name;
    private String email;
    private String profilePicture;

    public User(String name, String email, String profilePicture) {
        this.name = name;
        this.email = email;
        this.profilePicture = profilePicture;
    }
    public String getId() { return id; }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
