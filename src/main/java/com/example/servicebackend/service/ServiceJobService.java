package com.example.servicebackend.service;

import java.util.List;

import com.example.servicebackend.model.dto.ServiceJobDto;

public interface ServiceJobService {
    List<ServiceJobDto> getAllServices();
    void addService(ServiceJobDto serviceJobDto);
}
