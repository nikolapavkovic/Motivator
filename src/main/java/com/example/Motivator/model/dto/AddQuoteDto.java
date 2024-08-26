package com.example.Motivator.model.dto;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.model.QuoteType;
import lombok.Data;

@Data
public class AddQuoteDto {
    private String content;
    private String author;
    private String type;

    public static AddQuoteDto fromEntity(final QuoteEntity quoteEntity) {
        AddQuoteDto addQuoteDto = new AddQuoteDto();
        addQuoteDto.setContent(quoteEntity.getContent());
        addQuoteDto.setAuthor(quoteEntity.getAuthor());
        addQuoteDto.setType(quoteEntity.getType().name());
        return addQuoteDto;
    }

    public static QuoteEntity fromDto(final AddQuoteDto addQuoteDto) {
        QuoteEntity quoteEntity = new QuoteEntity();
        quoteEntity.setContent(addQuoteDto.getContent());
        quoteEntity.setAuthor(addQuoteDto.getAuthor());
        quoteEntity.setType(QuoteType.valueOf(addQuoteDto.getType()));
        return quoteEntity;
    }
}
