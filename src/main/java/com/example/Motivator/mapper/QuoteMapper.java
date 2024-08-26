package com.example.Motivator.mapper;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.model.QuoteType;
import com.example.Motivator.model.dto.AddQuoteDto;

public class QuoteMapper {
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
