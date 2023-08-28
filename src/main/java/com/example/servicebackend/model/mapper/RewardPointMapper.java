package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.RewardPointDto;
import com.example.servicebackend.model.entity.RewardPoint;
import com.example.servicebackend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RewardPointMapper {

    RewardPointMapper INSTANCE = Mappers.getMapper(RewardPointMapper.class);

    @Mapping(target = "userId", source = "user.userId")
    RewardPointDto toDto(RewardPoint rewardPoint);

    @Mapping(target = "user", source = "userId", qualifiedByName = "userIdToUser")
    RewardPoint toEntity(RewardPointDto rewardPointDto);

    @Named("userIdToUser")
    default User userIdToUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        return user;
    }
}
