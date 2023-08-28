package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportDto {
    private Long reportId;
    private String content;
    private String userId;
    private Long bookingId;
}
