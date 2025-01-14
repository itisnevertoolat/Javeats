package com.javaprojects.javeats.exceptions;

public class DuplicationValueException extends Exception{

    public DuplicationValueException(String message){
        super(String.format("The Provided %s already exists", message));
    }
}
