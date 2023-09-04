package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.ServiceJobDto;
import com.example.servicebackend.service.ServiceJobService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
@Tag(name = "Service Job API")
@SecurityRequirement(name = "Authorization")
public class ServiceJobController {

    private final ServiceJobService serviceJobService;

    @GetMapping("")
    public ResponseEntity<?> getAllServices() {
        List<ServiceJobDto> serviceJobDtos = serviceJobService.getAllServices();
        if (serviceJobDtos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(serviceJobDtos);
    }

    @PostMapping("")
    public ResponseEntity<?> addService(@RequestBody ServiceJobDto serviceJobDto) {
        ServiceJobDto res = serviceJobService.addService(serviceJobDto);
        if (res == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.created(null).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable Long id) {
        ServiceJobDto serviceJobDto = serviceJobService.getServiceById(id);
        if (serviceJobDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(serviceJobDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateService(@PathVariable("id") Long id, @RequestBody ServiceJobDto serviceJobDto) {
        ServiceJobDto res = serviceJobService.updateService(id, serviceJobDto);
        if (res == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }
}
