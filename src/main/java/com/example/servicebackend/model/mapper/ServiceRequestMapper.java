package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.ServiceRequestDto;
import com.example.servicebackend.model.entity.ServiceJob;
import com.example.servicebackend.model.entity.ServiceRequest;
import com.example.servicebackend.model.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceRequestMapper {
    ServiceRequestMapper INSTANCE = Mappers.getMapper(ServiceRequestMapper.class);

    @Mapping(target = "serviceJobId", source = "serviceJob.serviceId")
    @Mapping(target = "userId", source = "user.userId")
    ServiceRequestDto toDto(ServiceRequest serviceRequest);

    @Mapping(
            target = "serviceJob",
            source = "serviceJobId",
            qualifiedByName = "mapServiceJobIdToServiceJob"
    )
    @Mapping(
        target = "user",
        source = "userId",
        qualifiedByName = "mapUserIdToUser"
    )
    @Mapping(target = "booking", ignore = true)
    @Mapping(target = "comboAssociations", ignore = true)
    @Mapping(target = "userDiscountAssociations", ignore = true)
    ServiceRequest toEntity(ServiceRequestDto serviceRequestDto);

    @Named("mapServiceJobIdToServiceJob")
    default ServiceJob mapServiceJobIdToServiceJob(Long serviceJobId) {
        ServiceJob serviceJob = new ServiceJob();
        serviceJob.setServiceId(serviceJobId);
        return serviceJob;
    }

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        return user;
    }
}
