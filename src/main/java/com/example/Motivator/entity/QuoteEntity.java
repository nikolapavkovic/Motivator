package com.example.Motivator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class QuoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quote", nullable = false)
    private String quote;

    @Column(name = "author")
    private String author;
}
