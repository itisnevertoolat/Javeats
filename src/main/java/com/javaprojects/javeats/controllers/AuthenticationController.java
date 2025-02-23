package com.javaprojects.javeats.controllers;

import com.javaprojects.javeats.dto.LoginRequest;
import com.javaprojects.javeats.dto.LoginResponse;
import com.javaprojects.javeats.dto.RegisterRequest;
import com.javaprojects.javeats.entities.*;
import com.javaprojects.javeats.exception.*;
import com.javaprojects.javeats.service.UserService;
import com.javaprojects.javeats.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class AuthenticationController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/api/auth/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request)
            throws ParameterNotFoundException, DuplicationValueException{

        userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request)
            throws ParameterNotFoundException, DuplicationValueException{

        Users user = userService.loginUser(request);
        String jwtToken = jwtUtil.generateToken(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpireIn(jwtUtil.getExpirationTime());
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);

    }
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.status(HttpStatus.OK).body("waht");

    }

}
