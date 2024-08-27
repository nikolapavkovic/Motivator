package com.example.Motivator.service;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteEntity getQuote(Integer id){
        Optional<QuoteEntity> quoteEntity = quoteRepository.findById(id);
        return quoteEntity.orElse(null);
    }

    public void addQuote(QuoteEntity quoteEntity){
        quoteRepository.save(quoteEntity);
    }

}
