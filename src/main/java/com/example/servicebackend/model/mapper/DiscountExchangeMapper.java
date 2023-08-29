package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.DiscountExchangeDto;
import com.example.servicebackend.model.entity.DiscountExchange;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountExchangeMapper {

    DiscountExchangeMapper INSTANCE = Mappers.getMapper(DiscountExchangeMapper.class);

    DiscountExchange toEntity(DiscountExchangeDto discountExchangeDto);

    DiscountExchangeDto toDto(DiscountExchange discountExchange);
}
