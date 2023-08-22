package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.PartnerDto;
import com.example.servicebackend.model.entity.Partner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PartnerMapper {
    PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);
    PartnerDto toDto(Partner partner);
    Partner toEntity(PartnerDto partnerDto);
}
