package com.example.Motivator.model.dto;

import com.example.Motivator.entity.QuoteEntity;
import lombok.Data;

@Data
public class GetQuoteDto {
    private String content;
    private String author;
    private String type;

    public static GetQuoteDto fromEntity(final QuoteEntity quoteEntity) {
        GetQuoteDto getQuoteDto = new GetQuoteDto();
        getQuoteDto.setContent(quoteEntity.getContent());
        getQuoteDto.setAuthor(quoteEntity.getAuthor());
        getQuoteDto.setType(quoteEntity.getType().name());
        return getQuoteDto;
    }
}
