package com.example.Motivator.service;

import com.example.Motivator.entity.QuoteEntity;
import com.example.Motivator.model.dto.AddQuoteDto;
import com.example.Motivator.model.dto.QuoteDto;
import com.example.Motivator.model.dto.mapper.QuoteMapper;
import com.example.Motivator.model.exception.QuoteNotFoundException;
import com.example.Motivator.model.exception.QuoteSmsException;
import com.example.Motivator.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteEntity getQuote(Long id) {
        Optional<QuoteEntity> quoteEntity = quoteRepository.findById(id);
        return quoteEntity.orElseThrow(() -> new QuoteNotFoundException("Quote not found!"));
    }

    public void addQuote(QuoteEntity quoteEntity) {
        quoteRepository.save(quoteEntity);
    }

    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }

    public QuoteDto updateQuote(Long id, AddQuoteDto quoteDto) {
        if (quoteRepository.existsById(id)) {
            return QuoteMapper.fromEntity(quoteRepository.save(QuoteMapper.fromDto(quoteDto, id)));

        } else throw new QuoteNotFoundException("Quote not found!");
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

    public ResponseBody sendQuoteByEmail(Long quoteId) {

        Optional<QuoteEntity> quoteEntity = quoteRepository.findById(quoteId);
        if (quoteEntity.isEmpty()) {
            throw new QuoteNotFoundException("Quote not found!");
        }

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(
                mediaType, String.format("{\"messages\":[{\"destinations\":[{\"to\":\"PhoneNumber\"}],\"from\":\"447491163443\",\"text\":\"Hi!\\n\\nHere's a great quote to get you inspired.\\n\\n%s\\n\\nBy: %s\"}]}",
                        quoteEntity.get().getContent(), quoteEntity.get().getAuthor()));
        Request request = new Request.Builder().url("https://3gx9mj.api.infobip.com/sms/2/text/advanced").method("POST", body).addHeader("Authorization", "App API key").addHeader("Content-Type", "application/json").addHeader("Accept", "application/json").build();

        Response response;

        try{
            response = client.newCall(request).execute();
        }
        catch (IOException e){
            throw new QuoteSmsException(e.getMessage());
        }

        if(!response.isSuccessful()) {
            throw new QuoteNotFoundException("Check if the phone number is valid");
        }

        return response.body();
    }
}
