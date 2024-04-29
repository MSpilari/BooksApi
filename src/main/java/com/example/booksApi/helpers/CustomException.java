package com.example.booksApi.helpers;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final HttpStatus status;

    public CustomException(HttpStatus statusCode, String message) {
        super(message);
        this.status = statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
