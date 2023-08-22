package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.UserDto;

public interface UserService {
    UserDto getUserById(String userId);
    UserDto addUser(UserDto userDto);
}
