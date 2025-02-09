package com.javaprojects.javeats.service;

import com.javaprojects.javeats.entity.Users;
import com.javaprojects.javeats.exception.*;

public interface UserService {
    public void registerUser(Users user) throws ParameterNotFoundException, DuplicationValueException;
    public void loginUser(Users users) throws ParameterNotFoundException;
}
