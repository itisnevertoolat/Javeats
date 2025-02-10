package com.javaprojects.javeats.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String username;
    private String email;
    private String password;
}
