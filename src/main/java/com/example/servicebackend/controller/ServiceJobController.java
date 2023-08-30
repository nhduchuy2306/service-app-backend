package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.model.dto.ServiceJobDto;
import com.example.servicebackend.service.ServiceJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
public class ServiceJobController {

    private final ServiceJobService serviceJobService;

    @GetMapping("")
    public ResponseEntity<?> getAllServices() {
        List<ServiceJobDto> serviceJobDtos = serviceJobService.getAllServices();
        return ResponseEntity.ok(new ResponseDto("Get all services successfully", serviceJobDtos, HttpStatus.OK.value()));
    }

    @PostMapping("")
    public ResponseEntity<?> addService(@RequestBody ServiceJobDto serviceJobDto) {
        ServiceJobDto res = serviceJobService.addService(serviceJobDto);
        return ResponseEntity.created(null).body(new ResponseDto("Add service successfully", res, HttpStatus.CREATED.value()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable Long id) {
        ServiceJobDto serviceJobDto = serviceJobService.getServiceById(id);
        if (serviceJobDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Service not found", null, HttpStatus.NOT_FOUND.value()));
        }
        return ResponseEntity.ok(new ResponseDto("Get service successfully", serviceJobDto, HttpStatus.OK.value()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateService(@PathVariable("id") Long id, @RequestBody ServiceJobDto serviceJobDto) {
        ServiceJobDto res = serviceJobService.updateService(id, serviceJobDto);
        if (res == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Service not found", null, HttpStatus.NOT_FOUND.value()));
        }
        return ResponseEntity.ok(new ResponseDto("Update service successfully", res, HttpStatus.OK.value()));
    }
}
