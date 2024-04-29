package com.example.booksApi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "books")
@AllArgsConstructor
public class Book {
    @Id
    private String id;

    @NotBlank(message = "The name is blank")
    @NotEmpty(message = "The name is empty")
    @NotNull(message = "The name is null")
    public String name;

    @NotBlank(message = "The category is blank")
    @NotEmpty(message = "The category is empty")
    @NotNull(message = "The category is null")
    public String category;

}
