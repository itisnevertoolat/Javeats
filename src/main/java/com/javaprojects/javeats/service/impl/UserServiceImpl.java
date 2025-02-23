package com.javaprojects.javeats.service.impl;

import com.javaprojects.javeats.dto.LoginRequest;
import com.javaprojects.javeats.dto.RegisterRequest;
import com.javaprojects.javeats.entities.Users;
import com.javaprojects.javeats.exception.*;
import com.javaprojects.javeats.repository.UserRepository;
import com.javaprojects.javeats.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

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
    public Users loginUser(LoginRequest request) throws ParameterNotFoundException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        return userRepository.findByEmail(request.getEmail()).orElseThrow();
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
