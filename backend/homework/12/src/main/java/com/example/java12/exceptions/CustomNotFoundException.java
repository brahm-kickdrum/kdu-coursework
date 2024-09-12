package com.example.java12.exceptions;

public class CustomNotFoundException extends Throwable {
    public CustomNotFoundException(String message) {
        super(message);
    }
}
