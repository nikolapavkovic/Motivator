package com.example.Motivator.repository;

import com.example.Motivator.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Integer> {
}
