package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.ComboDto;
import com.example.servicebackend.model.entity.Combo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComboMapper {

    ComboMapper INSTANCE = Mappers.getMapper(ComboMapper.class);

    ComboDto toDto(ComboDto comboDto);

    Combo toEntity(Combo combo);

}
