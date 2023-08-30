package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.UserDiscountAssociationDto;
import com.example.servicebackend.model.entity.ServiceRequest;
import com.example.servicebackend.model.entity.UserDiscount;
import com.example.servicebackend.model.entity.UserDiscountAssociation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDiscountAssociationMapper {
    UserDiscountAssociationMapper INSTANCE = Mappers.getMapper(UserDiscountAssociationMapper.class);

    @Mapping(target = "userDiscountId", source = "userDiscount.userDiscountId")
    @Mapping(target = "requestId", source = "serviceRequest.requestId")
    UserDiscountAssociationDto toDto(UserDiscountAssociation userDiscountAssociation);

    @Mapping(target = "userDiscount", source = "userDiscountId", qualifiedByName = "mapUserDiscountIdToUserDiscount")
    @Mapping(target = "serviceRequest", source = "requestId", qualifiedByName = "mapRequestIdToServiceRequest")
    UserDiscountAssociation toEntity(UserDiscountAssociationDto userDiscountAssociationDto);

    @Named("mapUserDiscountIdToUserDiscount")
    default UserDiscount mapUserDiscountIdToUserDiscount(Long userDiscountId) {
        UserDiscount userDiscount = new UserDiscount();
        userDiscount.setUserDiscountId(userDiscountId);
        return userDiscount;
    }

    @Named("mapRequestIdToServiceRequest")
    default ServiceRequest mapRequestIdToServiceRequest(Long requestId) {
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setRequestId(requestId);
        return serviceRequest;
    }

}
