package com.javaprojects.javeats.service;

import com.javaprojects.javeats.entities.Users;
import com.javaprojects.javeats.exceptions.*;

public interface UserService {
    public void registerUser(Users user) throws ParameterNotFoundException, DuplicationValueException;
}
