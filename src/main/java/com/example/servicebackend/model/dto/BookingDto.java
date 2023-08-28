package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {
    private Long bookingId;
    private String status;
    private String partnerId;
    private Long serviceRequestId;
}
