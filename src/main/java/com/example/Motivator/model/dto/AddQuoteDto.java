package com.example.Motivator.model.dto;

import com.example.Motivator.model.QuoteType;
import lombok.Data;

@Data
public class AddQuoteDto {
    private String content;
    private String author;
    private String type;
}
