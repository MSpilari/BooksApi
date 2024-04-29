package com.example.booksApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.booksApi.helpers.CustomException;
import com.example.booksApi.models.Book;
import com.example.booksApi.repositories.BooksRepository;

@Service
public class BookService {
    @Autowired
    private BooksRepository booksRepository;

    public List<Book> getBooks() {
        return booksRepository.findAll();
    }

    public Book getABookById(String id) {
        Book book = booksRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "Id not found"));

        return book;
    }

    public Book getABookByName(String bookName) {
        Book book = booksRepository.findByName(bookName)
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "Book name not found"));

        return book;
    }

    public Book saveBook(Book book) {
        boolean bookExists = booksRepository.findByName(book.name).isPresent();

        if (bookExists) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Book already registered");
        }

        return booksRepository.save(book);
    }

    public Book updateBook(String id, Book book) {
        Book oldBook = booksRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "Id not found"));

        oldBook.setName(book.name);
        oldBook.setCategory(book.category);
        return booksRepository.save(oldBook);
    }

    public Book deleteBookById(String id) {
        Book deletedBook = booksRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, "Id not found"));
        booksRepository.deleteById(id);

        return deletedBook;
    }
}
