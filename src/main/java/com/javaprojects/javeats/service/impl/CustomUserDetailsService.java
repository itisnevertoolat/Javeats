package com.javaprojects.javeats.service.impl;

import com.javaprojects.javeats.entity.Users;
import com.javaprojects.javeats.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user =
                userRepository.findByEmail(email).orElseThrow(
                        ()-> new UsernameNotFoundException("provided email or password incorrect"));
        return user;
    }
}
