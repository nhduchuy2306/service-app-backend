package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.UserDto;
import com.example.servicebackend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);

    @Mapping(target = "paymentMethods", ignore = true)
    @Mapping(target = "reports", ignore = true)
    @Mapping(target = "rewardPoints", ignore = true)
    @Mapping(target = "serviceRequests", ignore = true)
    @Mapping(target = "wallet", ignore = true)
    User toUser(UserDto userDto);
}
