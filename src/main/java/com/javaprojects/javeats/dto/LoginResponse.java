package com.javaprojects.javeats.dto;


import lombok.*;

@Getter
@Setter
public class LoginResponse {

    private String token;
    private long expireIn;
}
