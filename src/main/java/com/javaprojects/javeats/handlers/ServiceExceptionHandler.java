package com.javaprojects.javeats.handlers;

import com.javaprojects.javeats.exceptions.DuplicationValueException;
import com.javaprojects.javeats.exceptions.ParameterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler({ParameterNotFoundException.class})
    public ResponseEntity<String> handleParameterNotFoundException(ParameterNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DuplicationValueException.class})
    public ResponseEntity<String> handleDuplicationValueException(DuplicationValueException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
