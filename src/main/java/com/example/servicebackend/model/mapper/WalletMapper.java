package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.WalletDto;
import com.example.servicebackend.model.entity.Partner;
import com.example.servicebackend.model.entity.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletMapper {
    WalletMapper INSTANCE = Mappers.getMapper(WalletMapper.class);
    @Mapping(target = "partnerId", source = "partner.partnerId")
    WalletDto toDto(Wallet wallet);
    @Mapping(target = "partner", source = "partnerId", qualifiedByName = "mapPartnerIdToPartner")
    Wallet toEntity(WalletDto walletDto);

    @Named("mapPartnerIdToPartner")
    default Partner mapPartnerIdToPartner(String partnerId) {
        Partner partner = new Partner();
        partner.setPartnerId(partnerId);
        return partner;
    }
}
