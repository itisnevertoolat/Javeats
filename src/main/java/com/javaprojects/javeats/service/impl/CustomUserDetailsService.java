package com.javaprojects.javeats.service.impl;

import com.javaprojects.javeats.entities.Users;
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
        var user =
                userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email not found " + email));
        return user;
    }
}
