package com.javaprojects.javeats.controllers;

import com.javaprojects.javeats.entities.*;
import com.javaprojects.javeats.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegisterController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public String register(@RequestBody Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.registerUser(user);
        return String.format("user %s has been registered successfully", user.getUsername());

    }

    @GetMapping("/register")
    public String register(){
        return "heollo";
    }

}
