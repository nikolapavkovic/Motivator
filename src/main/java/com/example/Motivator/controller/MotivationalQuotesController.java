package com.example.Motivator.controller;

import com.example.Motivator.model.dto.QuoteDto;
import com.example.Motivator.model.dto.mapper.QuoteMapper;
import com.example.Motivator.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/1/quotes/motivational")
@RequiredArgsConstructor
public class MotivationalQuotesController {

    private final QuoteService quoteService;

    @PostMapping
    public void create(@RequestBody QuoteDto addQuoteDto){
        quoteService.addQuote(QuoteMapper.fromDto(addQuoteDto));
    }

    @GetMapping("/{id}")
    public QuoteDto getById(@PathVariable Integer id){
        return QuoteMapper.fromEntity(quoteService.getQuote(id));
    }

}
