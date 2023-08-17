package com.example.servicebackend.service;

import java.util.List;

import com.example.servicebackend.model.dto.ServiceDto;

public interface ServiceJobService {
    public List<ServiceDto> getAllServices();
}
