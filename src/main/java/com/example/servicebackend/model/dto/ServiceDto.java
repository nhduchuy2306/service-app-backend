package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    private Long serviceId;
    private String serviceName;
    private String description;
    private Double price;
}
