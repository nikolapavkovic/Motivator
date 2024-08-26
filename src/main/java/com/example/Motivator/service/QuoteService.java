package com.example.Motivator.service;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteEntity getQuote(Long id){
        return quoteRepository.findById(id);
    }

}
