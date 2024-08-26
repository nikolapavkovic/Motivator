package com.example.Motivator.service;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.mapper.QuoteMapper;
import com.example.Motivator.model.QuoteType;
import com.example.Motivator.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public Optional<QuoteEntity> getQuote(Integer id){
        return quoteRepository.findById(id);
    }

    public void addQuote(QuoteEntity quoteEntity){
        quoteRepository.save(quoteEntity);
    }

}
