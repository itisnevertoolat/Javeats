package com.javaprojects.javeats.exceptions;

public class ParameterNotFoundException extends Exception{

    public ParameterNotFoundException(String message){
        super(String.format("the parameter %s should be provided", message));
    }
}
