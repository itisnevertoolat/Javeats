package com.javaprojects.javeats.controller;

import com.javaprojects.javeats.dto.UserDto;
import com.javaprojects.javeats.entity.*;
import com.javaprojects.javeats.exception.*;
import com.javaprojects.javeats.mapper.UserMapper;
import com.javaprojects.javeats.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegisterController {

    private final UserService userService;

    private final UserMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user)
            throws ParameterNotFoundException, DuplicationValueException{

        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user)
            throws ParameterNotFoundException, DuplicationValueException{

        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }

}
