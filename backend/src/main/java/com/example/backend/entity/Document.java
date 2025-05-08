package com.example.backend.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Document {

    private String id;

    private String title;

    private String uid;

    private List<String> content;

    private LocalDateTime createAt;
}
