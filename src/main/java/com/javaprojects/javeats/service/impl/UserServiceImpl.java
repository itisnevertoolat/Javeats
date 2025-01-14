package com.javaprojects.javeats.service.impl;

import com.javaprojects.javeats.dtos.UserDto;
import com.javaprojects.javeats.entities.Users;
import com.javaprojects.javeats.exceptions.*;
import com.javaprojects.javeats.repositories.UserRepository;
import com.javaprojects.javeats.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void registerUser(Users user)  throws ParameterNotFoundException, DuplicationValueException{

        validateRegistrationData(user);
        userRepository.save(user);
    }

    private void validateRegistrationData(Users user) throws ParameterNotFoundException, DuplicationValueException {
        if(Optional.ofNullable(user.getUsername()).isEmpty())
            throw new ParameterNotFoundException("username");
        if(Optional.ofNullable(user.getEmail()).isEmpty())
            throw new ParameterNotFoundException("Email");
        if(Optional.ofNullable(user.getPassword()).isEmpty())
            throw new ParameterNotFoundException("Password");

        Optional<Users> users = userRepository.findByUsername(user.getUsername());
        if(users.isPresent())
            throw new DuplicationValueException("Username");
        users = userRepository.findByEmail(user.getEmail());

        if(users.isPresent())
            throw new DuplicationValueException("Email");

    }
}
