package com.kdu.caching.exceptions.customexceptions;

public class InvalidJsonException extends RuntimeException {
    public InvalidJsonException(String message) {
        super(message);
    }
}
