package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.ServiceJobDto;
import com.example.servicebackend.model.entity.ServiceJob;
import com.example.servicebackend.model.mapper.ServiceJobMapper;
import com.example.servicebackend.repository.ServiceJobRepository;
import com.example.servicebackend.service.ServiceJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceJobImpl implements ServiceJobService {

    private final ServiceJobRepository serviceRepository;

    @Override
    public List<ServiceJobDto> getAllServices() {
        List<ServiceJobDto> serviceJobDtos = new ArrayList<>();
        List<ServiceJob> services = serviceRepository.findAll();

        for (ServiceJob service : services) {
            serviceJobDtos.add(ServiceJobMapper.INSTANCE.toDto(service));
        }
        return serviceJobDtos;
    }

    @Override
    public void addService(ServiceJobDto serviceJobDto) {
        ServiceJob serviceJob = ServiceJobMapper.INSTANCE.toEntity(serviceJobDto);
        serviceRepository.save(serviceJob);
    }

}
