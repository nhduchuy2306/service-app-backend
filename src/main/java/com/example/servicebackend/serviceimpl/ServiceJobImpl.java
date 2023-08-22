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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceJobImpl implements ServiceJobService {

    private final ServiceJobRepository serviceJobRepository;

    @Override
    public List<ServiceJobDto> getAllServices() {
        List<ServiceJobDto> serviceJobDtos = new ArrayList<>();
        List<ServiceJob> services = serviceJobRepository.findAll();

        for (ServiceJob service : services) {
            serviceJobDtos.add(ServiceJobMapper.INSTANCE.toDto(service));
        }
        return serviceJobDtos;
    }

    @Override
    public ServiceJobDto addService(ServiceJobDto serviceJobDto) {
        serviceJobDto.setServiceId(0L);
        ServiceJob serviceJob = ServiceJobMapper.INSTANCE.toEntity(serviceJobDto);
        ServiceJob res = serviceJobRepository.save(serviceJob);
        return ServiceJobMapper.INSTANCE.toDto(res);
    }

    @Override
    public ServiceJobDto getServiceById(Long id) {
        Optional<ServiceJob> serviceJob = serviceJobRepository.findById(id);
        return serviceJob.map(ServiceJobMapper.INSTANCE::toDto).orElse(null);
    }

}
