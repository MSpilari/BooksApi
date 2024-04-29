package com.example.booksApi.DTO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.booksApi.models.Book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book Controller", description = "All methods from books")
public interface BooksInterface {
    @Operation(summary = "Return all books", description = "All books that have been registered")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfull operation")
    })
    ResponseEntity<List<Book>> getAllBooks();

    @Operation(summary = "Return a book", description = "Find a book based on his id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfull operation."),
            @ApiResponse(responseCode = "400", description = "Bad request. Id does not exist."),
    })
    ResponseEntity<Book> getABookById();
}
