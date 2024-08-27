package com.example.Motivator.repository;

import com.example.Motivator.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Integer> {

    List<QuoteEntity> findAllByAuthor(String author);

    List<QuoteEntity> findAllByContentContaining(String text);

}
