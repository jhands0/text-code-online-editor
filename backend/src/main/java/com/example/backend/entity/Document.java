package com.example.backend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Document implements Serializable {

    private String id;

    private String title;

    private String uid;

    private List<String> content;

    private LocalDateTime createAt;
}
