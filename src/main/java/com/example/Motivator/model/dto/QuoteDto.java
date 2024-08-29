package com.example.Motivator.model.dto;

import lombok.Data;

@Data
public class QuoteDto {
    private Long id;
    private String content;
    private String author;
    private String type;
}
