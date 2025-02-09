package com.javaprojects.javeats.handler;

import com.javaprojects.javeats.exception.DuplicationValueException;
import com.javaprojects.javeats.exception.ParameterNotFoundException;
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
