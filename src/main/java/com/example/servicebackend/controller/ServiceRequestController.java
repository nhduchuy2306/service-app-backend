package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.model.dto.ServiceRequestDto;
import com.example.servicebackend.model.dto.UserDiscountAssociationDto;
import com.example.servicebackend.model.dto.UserDiscountDto;
import com.example.servicebackend.service.ServiceRequestService;
import com.example.servicebackend.service.UserDiscountService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/service-requests")
@RequiredArgsConstructor
@Tag(name = "Service Request API")
@SecurityRequirement(name = "Authorization")
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;
    private final UserDiscountService userDiscountService;

    @PostMapping("")
    public ResponseEntity<?> addServiceRequest(@RequestBody ServiceRequestDto serviceRequestDto) {
        ServiceRequestDto res = serviceRequestService.addServiceRequest(serviceRequestDto);
        return ResponseEntity.created(null).body(new ResponseDto("Add Service Request successfully",res, HttpStatus.CREATED.value()));
    }

    @PutMapping("/{serviceRequestId}/apply-discount/{userDiscountId}")
    public ResponseEntity<?> applyDiscount(@PathVariable Long serviceRequestId, @PathVariable Long userDiscountId) {
        ServiceRequestDto serviceRequestDto = serviceRequestService.getServiceRequestByServiceRequestId(serviceRequestId);
        UserDiscountDto userDiscountDto = userDiscountService.getUserDiscountByUserDiscountId(userDiscountId);
        UserDiscountAssociationDto res = serviceRequestService.applyDiscount(serviceRequestDto, userDiscountDto);

        if(serviceRequestDto == null && userDiscountDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Apply discount failed",null, HttpStatus.BAD_REQUEST.value()));
        }

        if(res == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Apply discount failed",null, HttpStatus.BAD_REQUEST.value()));
        }

        return ResponseEntity.ok(new ResponseDto("Apply discount successfully",res, HttpStatus.OK.value()));
    }
}
