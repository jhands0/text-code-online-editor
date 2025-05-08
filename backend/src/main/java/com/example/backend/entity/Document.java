package com.example.backend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Document implements Serializable {

    @NotBlank(message = "Id is mandatory")
    private String id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "User Id is mandatory")
    private String uid;

    @NotBlank(message = "Content is mandatory")
    private List<String> content;

    @NotBlank(message = "Timestamp is mandatory")
    private LocalDateTime createAt;
}
