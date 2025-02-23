package com.javaprojects.javeats.service;

import com.javaprojects.javeats.dto.LoginRequest;
import com.javaprojects.javeats.dto.RegisterRequest;
import com.javaprojects.javeats.entities.Users;
import com.javaprojects.javeats.exception.*;

public interface UserService {
    public void registerUser(RegisterRequest request) throws ParameterNotFoundException, DuplicationValueException;
    public Users loginUser(LoginRequest request) throws ParameterNotFoundException;
}
