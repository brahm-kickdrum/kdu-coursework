package com.example.springboot.exception.custom;

public class entityNotFoundException extends IndexOutOfBoundsException{
    public entityNotFoundException(String s) {
        super(s);
    }
}
