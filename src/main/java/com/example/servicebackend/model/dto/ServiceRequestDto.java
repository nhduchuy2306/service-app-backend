package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceRequestDto {
    private Long requestId;
    private String location;
    private String startTime;
    private String endTime;
    private String startDate;
    private String type;
    private String status;
    private String userId;
    private Long serviceJobId;
}
