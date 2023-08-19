package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceJobDto {
    private Long serviceId;
    private String serviceName;
    private String description;
    private Double price;
}
