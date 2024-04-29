package com.example.booksApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.booksApi.models.Book;
import com.example.booksApi.services.BookService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api")
@Validated
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookService.getBooks();

        return ResponseEntity.ok().body(allBooks);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getABookById(@PathVariable String id) {
        Book book = bookService.getABookById(id);

        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/newbook")
    public ResponseEntity<Book> saveBook(@RequestBody @Valid Book book) {
        Book newBook = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping("/book")
    public ResponseEntity<?> getBookByName(@RequestParam @NotNull @NotBlank @NotEmpty String name) {
        Book book = bookService.getABookByName(name);
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("updatebook/{id}")
    public ResponseEntity<Book> updateABook(@PathVariable String id, @RequestBody @Valid Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok().body(updatedBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBooKById(@PathVariable String id) {
        Book book = bookService.deleteBookById(id);

        return ResponseEntity.ok().body(book);
    }

}
