package com.javaprojects.javeats.service.impl;

import com.javaprojects.javeats.entities.Users;
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
    public void registerUser(Users user) {
        Optional<Users> users = userRepository.findByUsername(user.getUsername());

        userRepository.save(user);
    }
}
