package com.example.servicebackend.service;

import java.util.List;

import com.example.servicebackend.model.dto.ServiceRequestDto;
import com.example.servicebackend.model.dto.UserDiscountAssociationDto;
import com.example.servicebackend.model.dto.UserDiscountDto;

public interface ServiceRequestService {

    ServiceRequestDto addServiceRequest(ServiceRequestDto serviceRequestDto);

    UserDiscountAssociationDto applyDiscount(ServiceRequestDto serviceRequestDto, UserDiscountDto userDiscountDto);

    ServiceRequestDto getServiceRequestByServiceRequestId(Long serviceRequestId);

    List<ServiceRequestDto> getAllServiceRequests();
}
