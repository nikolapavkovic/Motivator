package com.example.Motivator.controller;

import com.example.Motivator.mapper.QuoteMapper;
import com.example.Motivator.model.dto.AddQuoteDto;
import com.example.Motivator.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/1/quotes/motivational")
@RequiredArgsConstructor
public class MotivationalQuotesController {

    private final QuoteService quoteService;

    @PostMapping
    public void create(@RequestBody AddQuoteDto addQuoteDto){
        quoteService.addQuote(QuoteMapper.fromDto(addQuoteDto));
    }

}
