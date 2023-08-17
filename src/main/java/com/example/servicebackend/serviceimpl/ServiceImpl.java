package com.example.servicebackend.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.servicebackend.model.dto.ServiceDto;
import com.example.servicebackend.repository.ServiceRepository;
import com.example.servicebackend.service.ServiceJobService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceJobService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<ServiceDto> getAllServices() {
        return null;
    }

}
