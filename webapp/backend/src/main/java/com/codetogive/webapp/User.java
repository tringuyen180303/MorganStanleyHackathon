package com.codetogive.webapp;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private ArrayList<byte[]> pdfFiles = new ArrayList<>();

    // getters and setters
}


