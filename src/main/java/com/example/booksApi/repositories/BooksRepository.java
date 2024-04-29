package com.example.booksApi.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.booksApi.models.Book;

public interface BooksRepository extends MongoRepository<Book, String> {
    Optional<Book> findByName(String name);
}
