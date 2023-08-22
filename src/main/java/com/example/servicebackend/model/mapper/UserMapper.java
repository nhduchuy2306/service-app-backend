package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.UserDto;
import com.example.servicebackend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

     UserDto toUserDto(User user);

     User toUser(UserDto userDto);
}
