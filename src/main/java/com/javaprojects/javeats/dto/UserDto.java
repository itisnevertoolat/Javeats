package com.javaprojects.javeats.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class UserDto {
    private Integer user_id;
    private String username;
    private String email;

    @Override
    public String toString() {
        return "{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
