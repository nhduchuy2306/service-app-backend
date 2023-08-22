package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.ServiceRequestDto;
import com.example.servicebackend.service.ServiceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/service-requests")
@RequiredArgsConstructor
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    @PostMapping("/")
    public ResponseEntity<?> addServiceRequest(@RequestBody ServiceRequestDto serviceRequestDto) {
        ServiceRequestDto res = serviceRequestService.addServiceRequest(serviceRequestDto);
        return ResponseEntity.created(null).body(res);
    }
}
