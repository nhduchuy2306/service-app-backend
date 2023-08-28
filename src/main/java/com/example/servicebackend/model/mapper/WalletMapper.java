package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.WalletDto;
import com.example.servicebackend.model.entity.Partner;
import com.example.servicebackend.model.entity.User;
import com.example.servicebackend.model.entity.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletMapper {

    WalletMapper INSTANCE = Mappers.getMapper(WalletMapper.class);
    @Mapping(target = "partnerId", source = "partner.partnerId")
    @Mapping(target = "userId", source = "user.userId")
    WalletDto toDto(Wallet wallet);
    @Mapping(target = "partner", source = "partnerId", qualifiedByName = "mapPartnerIdToPartner")
    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    Wallet toEntity(WalletDto walletDto);

    @Named("mapPartnerIdToPartner")
    default Partner mapPartnerIdToPartner(String partnerId) {
        Partner partner = new Partner();
        partner.setPartnerId(partnerId);
        return partner;
    }

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        return user;
    }

}
