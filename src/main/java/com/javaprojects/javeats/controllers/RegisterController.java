package com.javaprojects.javeats.controllers;

import com.javaprojects.javeats.entities.*;
import com.javaprojects.javeats.exceptions.*;
import com.javaprojects.javeats.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user)
            throws ParameterNotFoundException, DuplicationValueException{

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.registerUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }

}
