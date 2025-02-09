package com.javaprojects.javeats.service.impl;

import com.javaprojects.javeats.entity.Users;
import com.javaprojects.javeats.exception.*;
import com.javaprojects.javeats.repository.UserRepository;
import com.javaprojects.javeats.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(Users user)  throws ParameterNotFoundException, DuplicationValueException{

        validateRegistrationData(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void loginUser(Users users) throws ParameterNotFoundException {

    }

    private void validateRegistrationData(Users user) throws ParameterNotFoundException, DuplicationValueException {
        if(Optional.ofNullable(user.getUsername()).isEmpty())
            throw new ParameterNotFoundException("Username");
        if(Optional.ofNullable(user.getEmail()).isEmpty())
            throw new ParameterNotFoundException("Email");
        if(Optional.ofNullable(user.getPassword()).isEmpty())
            throw new ParameterNotFoundException("Password");

        Optional<Users> users = userRepository.findByEmail(user.getEmail());

        if(users.isPresent())
            throw new DuplicationValueException("Email");

    }
}
