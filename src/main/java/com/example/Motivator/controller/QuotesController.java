package com.example.Motivator.controller;

import com.example.Motivator.model.dto.AddQuoteDto;
import com.example.Motivator.model.dto.QuoteDto;
import com.example.Motivator.model.dto.mapper.QuoteMapper;
import com.example.Motivator.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/1/quotes")
@RequiredArgsConstructor
public class QuotesController {
    private final QuoteService quoteService;

    @PostMapping
    public void create(@RequestBody QuoteDto quote) {
        quoteService.addQuote(QuoteMapper.fromDto(quote));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public QuoteDto getById(@PathVariable Long id) {
        return QuoteMapper.fromEntity(quoteService.getQuote(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        quoteService.deleteQuote(id);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public QuoteDto update(@PathVariable Long id, @RequestBody AddQuoteDto quote) {
        return quoteService.updateQuote(id, quote);
    }

    @GetMapping("/findByAuthor/{author}")
    public List<QuoteDto> getAllQuotesByAuthor(@PathVariable String author) {
        return quoteService.getAllQuotesByAuthor(author);
    }

    @GetMapping("/contains/{text}")
    public List<QuoteDto> getAllQuotesContaining(@PathVariable String text) {
        return quoteService.getAllContaining(text);
    }

    @GetMapping("/getAllAuthors")
    public List<String> getAllAuthors() {
        return quoteService.getAllAuthors();
    }

    @PostMapping("/sendBySms/{quoteId}")
    public okhttp3.ResponseBody sendQuoteToEmail(@PathVariable Long quoteId) {
        return quoteService.sendQuoteByEmail(quoteId);
    }
}
