package org.example.question1;


public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message, MissingGradeException cause){
        super(message, cause);
    }

}


