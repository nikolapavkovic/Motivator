package com.example.Motivator.model.dto.mapper;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.model.QuoteType;
import com.example.Motivator.model.dto.QuoteDto;

public class QuoteMapper {

    public static QuoteDto fromEntity(final QuoteEntity quoteEntity) {
        QuoteDto quoteDto = new QuoteDto();
        quoteDto.setContent(quoteEntity.getContent());
        quoteDto.setAuthor(quoteEntity.getAuthor());
        quoteDto.setType(quoteEntity.getType().name());
        return quoteDto;
    }

    public static QuoteEntity fromDto(final QuoteDto addQuoteDto) {
        QuoteEntity quoteEntity = new QuoteEntity();
        quoteEntity.setContent(addQuoteDto.getContent());
        quoteEntity.setAuthor(addQuoteDto.getAuthor());
        quoteEntity.setType(QuoteType.valueOf(addQuoteDto.getType()));
        return quoteEntity;
    }

    public static QuoteEntity fromDto(final QuoteDto addQuoteDto, final Long id) {
        QuoteEntity quoteEntity = new QuoteEntity();
        quoteEntity.setId(id);
        quoteEntity.setContent(addQuoteDto.getContent());
        quoteEntity.setAuthor(addQuoteDto.getAuthor());
        quoteEntity.setType(QuoteType.valueOf(addQuoteDto.getType()));
        return quoteEntity;
    }
}
