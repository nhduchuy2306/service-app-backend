package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.ServiceJobDto;
import com.example.servicebackend.model.entity.ServiceJob;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceJobMapper {
     ServiceJobMapper INSTANCE = Mappers.getMapper(ServiceJobMapper.class);
     ServiceJobDto toDto(ServiceJob serviceJob);
     ServiceJob toEntity(ServiceJobDto serviceJobDto);
}