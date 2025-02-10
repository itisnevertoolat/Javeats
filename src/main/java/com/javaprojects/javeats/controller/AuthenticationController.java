package com.javaprojects.javeats.controller;

import com.javaprojects.javeats.dto.RegisterRequest;
import com.javaprojects.javeats.entity.*;
import com.javaprojects.javeats.exception.*;
import com.javaprojects.javeats.mapper.UserMapper;
import com.javaprojects.javeats.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request)
            throws ParameterNotFoundException, DuplicationValueException{

        userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user)
            throws ParameterNotFoundException, DuplicationValueException{


        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }

}
