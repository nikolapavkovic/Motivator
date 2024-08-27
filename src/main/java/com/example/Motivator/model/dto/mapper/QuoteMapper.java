package com.example.Motivator.model.dto.mapper;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.model.QuoteType;
import com.example.Motivator.model.dto.QuoteDto;

public class QuoteMapper {

    public static QuoteDto fromEntity(final QuoteEntity quoteEntity) {
        QuoteDto addQuoteDto = new QuoteDto();
        addQuoteDto.setContent(quoteEntity.getContent());
        addQuoteDto.setAuthor(quoteEntity.getAuthor());
        addQuoteDto.setType(quoteEntity.getType().name());
        return addQuoteDto;
    }

    public static QuoteEntity fromDto(final QuoteDto addQuoteDto) {
        QuoteEntity quoteEntity = new QuoteEntity();
        quoteEntity.setContent(addQuoteDto.getContent());
        quoteEntity.setAuthor(addQuoteDto.getAuthor());
        quoteEntity.setType(QuoteType.valueOf(addQuoteDto.getType()));
        return quoteEntity;
    }
}
