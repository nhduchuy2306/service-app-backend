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

    @Override
    public ServiceJobDto updateService(Long id, ServiceJobDto serviceJobDto) {
        Optional<ServiceJob> serviceJob = serviceJobRepository.findById(id);
        if (serviceJob.isPresent()) {
            ServiceJob service = serviceJob.get();
            service.setServiceName(
                    serviceJobDto.getServiceName() == null || serviceJobDto.getServiceName() == "" ?
                            service.getServiceName() :
                            serviceJobDto.getServiceName()
            );
            service.setPrice(
                    serviceJobDto.getPrice() == null || serviceJobDto.getPrice() == 0 ?
                            service.getPrice() :
                            serviceJobDto.getPrice()
            );
            service.setDescription(
                    serviceJobDto.getDescription() == null || serviceJobDto.getDescription() == "" ?
                            service.getDescription() :
                            serviceJobDto.getDescription()
            );

            ServiceJob res = serviceJobRepository.save(service);
            return ServiceJobMapper.INSTANCE.toDto(res);
        }
        return null;
    }

}
