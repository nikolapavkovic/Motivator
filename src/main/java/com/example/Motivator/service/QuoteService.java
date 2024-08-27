package com.example.Motivator.service;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.model.dto.AddQuoteDto;
import com.example.Motivator.model.dto.QuoteDto;
import com.example.Motivator.model.dto.mapper.QuoteMapper;
import com.example.Motivator.model.exception.QuoteNotFoundException;
import com.example.Motivator.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteEntity getQuote(Integer id) {
        Optional<QuoteEntity> quoteEntity = quoteRepository.findById(id);
        return quoteEntity.orElseThrow(() -> new QuoteNotFoundException("Quote not found!"));
    }

    public void addQuote(QuoteEntity quoteEntity) {
        quoteRepository.save(quoteEntity);
    }

    public void deleteQuote(Integer id) {
        quoteRepository.deleteById(id);
    }

    public QuoteDto updateQuote(Long id, AddQuoteDto quoteDto) {
        return QuoteMapper.fromEntity(quoteRepository.save(QuoteMapper.fromDto(quoteDto, id)));
    }

    public List<QuoteDto> getAllQuotesByAuthor(String author) {
        List<QuoteEntity> quoteEntities = quoteRepository.findAllByAuthor(author);
        List<QuoteDto> quoteDtos = new ArrayList<>();

        for (QuoteEntity quoteEntity : quoteEntities) {
            quoteDtos.add(QuoteMapper.fromEntity(quoteEntity));
        }
        return quoteDtos;
    }

    public List<QuoteDto> getAllContaining(String text) {
        List<QuoteEntity> quoteEntities = quoteRepository.findAllByContentContaining(text);

        List<QuoteDto> quoteDtos = new ArrayList<>();

        for (QuoteEntity quoteEntity : quoteEntities) {
            quoteDtos.add(QuoteMapper.fromEntity(quoteEntity));
        }

        return quoteDtos;
    }

    public List<String> getAllAuthors() {
        List<QuoteEntity> quoteEntities = quoteRepository.findAll();
        List<String> authors = new ArrayList<>();

        for (QuoteEntity quoteEntity : quoteEntities) {
            authors.add(quoteEntity.getAuthor());
        }

        return authors.stream().distinct().collect(Collectors.toList());
    }

}
