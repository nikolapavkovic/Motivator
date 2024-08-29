package com.example.Motivator.entity;

import com.example.Motivator.model.QuoteType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "quote")
public class QuoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private QuoteType type;
}
