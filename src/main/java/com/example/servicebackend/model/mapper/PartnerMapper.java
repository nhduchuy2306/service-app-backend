package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.PartnerDto;
import com.example.servicebackend.model.entity.Partner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PartnerMapper {

    PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);
    
    PartnerDto toDto(Partner partner);

    @Mapping(target = "partnerWorkingTypes", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "wallet", ignore = true)
    Partner toEntity(PartnerDto partnerDto);

}
