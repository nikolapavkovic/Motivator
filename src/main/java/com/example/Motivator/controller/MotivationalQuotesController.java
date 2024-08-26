package com.example.Motivator.controller;

import com.example.Motivator.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/1/quotes/motivational")
@RequiredArgsConstructor
public class MotivationalQuotesController {

    private final QuoteService quoteService;

}
