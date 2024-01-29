package com.example.java10.exceptions;


import com.example.java10.dto.ErrorDto;
import com.example.java10.exceptions.customexceptions.ResourceNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorDto error = new ErrorDto(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.getCode());
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ErrorDto> handleBadRequestException(BadRequestException ex){
        ErrorDto error = new ErrorDto(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, error.getCode());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDto> handleAllException(BadRequestException ex){
        ErrorDto error = new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, error.getCode());
    }
}
