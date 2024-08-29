package com.example.Motivator.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddQuoteDto {
    private String content;
    private String author;
    private String type;
}
