package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.ServiceJobDto;
import com.example.servicebackend.model.entity.ServiceJob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceJobMapper {

     ServiceJobMapper INSTANCE = Mappers.getMapper(ServiceJobMapper.class);

     ServiceJobDto toDto(ServiceJob serviceJob);

     @Mapping(target = "partnerWorkingTypes", ignore = true)
     @Mapping(target = "serviceRequests", ignore = true)
     ServiceJob toEntity(ServiceJobDto serviceJobDto);
}