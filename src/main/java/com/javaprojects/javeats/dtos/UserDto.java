package com.javaprojects.javeats.dtos;

import lombok.*;

@Data
@AllArgsConstructor
public class UserDto {
    private Integer user_id;
    private String username;
    private String email;
}
