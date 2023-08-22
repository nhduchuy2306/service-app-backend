package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.ServiceJobDto;
import com.example.servicebackend.service.ServiceJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
public class ServiceJobController {

    private final ServiceJobService serviceJobService;

    @GetMapping("/")
    public ResponseEntity<?> getAllServices() {
        return ResponseEntity.ok(serviceJobService.getAllServices());
    }

    @PostMapping("/")
    public ResponseEntity<?> addService(@RequestBody ServiceJobDto serviceJobDto) {
        ServiceJobDto res = serviceJobService.addService(serviceJobDto);
        return ResponseEntity.created(null).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceJobService.getServiceById(id));
    }
}