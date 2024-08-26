package com.example.Motivator.controller;

import com.example.Motivator.model.dto.AddQuoteDto;
import com.example.Motivator.model.dto.GetQuoteDto;
import com.example.Motivator.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/1/quotes/motivational")
@RequiredArgsConstructor
public class MotivationalQuotesController {

    private final QuoteService quoteService;

    @PostMapping
    public void create(@RequestBody AddQuoteDto addQuoteDto){
        quoteService.addQuote(AddQuoteDto.fromDto(addQuoteDto));
    }

    @GetMapping("/{id}")
    public GetQuoteDto getById(@PathVariable Integer id){
        return GetQuoteDto.fromEntity(quoteService.getQuote(id));
    }

}
