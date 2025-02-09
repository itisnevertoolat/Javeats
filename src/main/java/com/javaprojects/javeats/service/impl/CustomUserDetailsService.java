package com.javaprojects.javeats.service.impl;

import com.javaprojects.javeats.entity.Users;
import com.javaprojects.javeats.mapper.UserMapper;
import com.javaprojects.javeats.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByEmail(username);
        if(Optional.ofNullable(user).isEmpty())
            throw new UsernameNotFoundException("provided email or password incorrect");

        return null;
    }
}
