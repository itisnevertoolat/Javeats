package com.javaprojects.javeats.mapper;

import com.javaprojects.javeats.dto.UserDto;
import com.javaprojects.javeats.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.security.core.userdetails.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
//    UserDto toDto(Users users);
//    Users fromDto(UserDto userDto);
//    @Mapping(source = "email", target = "username")
//    User toSecUser(Users users);

}
