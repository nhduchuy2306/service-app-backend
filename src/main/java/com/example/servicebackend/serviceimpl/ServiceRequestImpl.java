package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.ServiceRequestDto;
import com.example.servicebackend.model.dto.UserDiscountAssociationDto;
import com.example.servicebackend.model.dto.UserDiscountDto;
import com.example.servicebackend.model.entity.ServiceRequest;
import com.example.servicebackend.model.entity.UserDiscountAssociation;
import com.example.servicebackend.model.enumtype.UserDiscountAssociationEnum;
import com.example.servicebackend.model.mapper.ServiceRequestMapper;
import com.example.servicebackend.model.mapper.UserDiscountAssociationMapper;
import com.example.servicebackend.model.mapper.UserDiscountMapper;
import com.example.servicebackend.repository.ServiceRequestRepository;
import com.example.servicebackend.repository.UserDiscountAssociationRepository;
import com.example.servicebackend.service.ServiceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceRequestImpl implements ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;
    private final UserDiscountAssociationRepository userDiscountAssociationRepository;

    @Override
    public ServiceRequestDto addServiceRequest(ServiceRequestDto serviceRequestDto) {
        ServiceRequest serviceRequest = ServiceRequestMapper.INSTANCE.toEntity(serviceRequestDto);
        ServiceRequest newServiceRequest = serviceRequestRepository.save(serviceRequest);
        return ServiceRequestMapper.INSTANCE.toDto(newServiceRequest);
    }

    @Override
    public UserDiscountAssociationDto applyDiscount(ServiceRequestDto serviceRequestDto, UserDiscountDto userDiscountDto) {
        UserDiscountAssociation userDiscountAssociation = new UserDiscountAssociation();
        userDiscountAssociation.setServiceRequest(ServiceRequestMapper.INSTANCE.toEntity(serviceRequestDto));
        userDiscountAssociation.setUserDiscount(UserDiscountMapper.INSTANCE.toEntity(userDiscountDto));
        userDiscountAssociation.setStatus(UserDiscountAssociationEnum.ACTIVE);

        UserDiscountAssociation newUserDiscountAssociation = userDiscountAssociationRepository.save(userDiscountAssociation);
        return UserDiscountAssociationMapper.INSTANCE.toDto(newUserDiscountAssociation);
    }

    @Override
    public ServiceRequestDto getServiceRequestByServiceRequestId(Long serviceRequestId) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(serviceRequestId).orElse(null);
        if (serviceRequest != null) {
            return ServiceRequestMapper.INSTANCE.toDto(serviceRequest);
        }
        return null;
    }
}
