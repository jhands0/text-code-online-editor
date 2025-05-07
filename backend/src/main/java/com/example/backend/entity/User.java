package com.example.backend.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User implements Serializable {

    private String id;
    private String name;
    private String email;
    private String profilePicture;

}
