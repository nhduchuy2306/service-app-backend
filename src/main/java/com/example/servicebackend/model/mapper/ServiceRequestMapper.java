package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.ServiceRequestDto;
import com.example.servicebackend.model.entity.ServiceJob;
import com.example.servicebackend.model.entity.ServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceRequestMapper {
    ServiceRequestMapper INSTANCE = Mappers.getMapper(ServiceRequestMapper.class);

    @Mapping(target = "requestId", source = "serviceRequest.requestId")
    ServiceRequestDto toDto(ServiceRequest serviceRequest);

    @Mapping(target = "serviceJob", source = "serviceJobId", qualifiedByName = "mapServiceJobIdToServiceJob")
    ServiceRequest toEntity(ServiceRequestDto serviceRequestDto);

    @Named("mapServiceJobIdToServiceJob")
    default ServiceJob mapServiceJobIdToServiceJob(Long serviceJobId) {
        ServiceJob serviceJob = new ServiceJob();
        serviceJob.setServiceId(serviceJobId);
        return serviceJob;
    }
}
