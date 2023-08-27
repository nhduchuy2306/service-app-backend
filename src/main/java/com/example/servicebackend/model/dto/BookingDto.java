package com.example.servicebackend.model.dto;

import com.example.servicebackend.model.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {
    private Long bookingId;
    private String status;
    private List<Report> reports;
    private String partnerId;
    private Long serviceRequestId;
}
