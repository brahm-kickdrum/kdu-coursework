package com.kdu.caching.exceptions;

import com.kdu.caching.dto.ErrorDto;
import com.kdu.caching.exceptions.customexceptions.InvalidAddressException;
import com.kdu.caching.exceptions.customexceptions.InvalidJsonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value={InvalidAddressException.class})
    public static ResponseEntity<ErrorDto> invalidAddressException(InvalidAddressException ex){
        ErrorDto error=new ErrorDto(ex.getMessage(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value={InvalidJsonException.class})
    public static ResponseEntity<ErrorDto> invalidJsonFormatException(InvalidJsonException ex){
        ErrorDto error=new ErrorDto(ex.getMessage(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<ErrorDto> exception(Exception ex){
        ErrorDto error=new ErrorDto(ex.getMessage(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}