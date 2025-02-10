package com.javaprojects.javeats.service.impl;

import com.javaprojects.javeats.dto.RegisterRequest;
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
    public void registerUser(RegisterRequest request)  throws ParameterNotFoundException, DuplicationValueException{

        validateRegistrationData(request);
        var user = Users.builder()
                        .username(request.getUsername())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .isEnabled(true)
                        .isAccountNonExpired(true)
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .build();

        userRepository.save(user);
    }

    @Override
    public void loginUser(Users users) throws ParameterNotFoundException {

    }

    private void validateRegistrationData(RegisterRequest request) throws ParameterNotFoundException, DuplicationValueException {
        if(Optional.ofNullable(request.getUsername()).isEmpty())
            throw new ParameterNotFoundException("Username");
        if(Optional.ofNullable(request.getEmail()).isEmpty())
            throw new ParameterNotFoundException("Email");
        if(Optional.ofNullable(request.getPassword()).isEmpty())
            throw new ParameterNotFoundException("Password");

        Optional<Users> users = userRepository.findByEmail(request.getEmail());

        if(users.isPresent())
            throw new DuplicationValueException("Email");

    }
}
