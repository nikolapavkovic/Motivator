package com.example.Motivator.repository;

import com.example.Motivator.model.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
