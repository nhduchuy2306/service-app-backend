package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.ServiceRequestDto;
import com.example.servicebackend.model.entity.ServiceRequest;
import com.example.servicebackend.model.mapper.ServiceRequestMapper;
import com.example.servicebackend.repository.ServiceRequestRepository;
import com.example.servicebackend.service.ServiceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceRequestImpl implements ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;

    @Override
    public ServiceRequestDto addServiceRequest(ServiceRequestDto serviceRequestDto) {
        ServiceRequest serviceRequest = ServiceRequestMapper.INSTANCE.toEntity(serviceRequestDto);
        ServiceRequest newServiceRequest = serviceRequestRepository.save(serviceRequest);
        return ServiceRequestMapper.INSTANCE.toDto(newServiceRequest);
    }
}
