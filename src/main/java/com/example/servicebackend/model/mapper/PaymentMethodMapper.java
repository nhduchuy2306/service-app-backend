package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.PaymentMethodDto;
import com.example.servicebackend.model.entity.PaymentMethod;
import com.example.servicebackend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMethodMapper {

    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

    @Mapping(target = "userId", source = "user.userId")
    PaymentMethodDto toDto(PaymentMethod paymentMethod);

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    PaymentMethod toEntity(PaymentMethodDto paymentMethodDto);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        return user;
    }
}
