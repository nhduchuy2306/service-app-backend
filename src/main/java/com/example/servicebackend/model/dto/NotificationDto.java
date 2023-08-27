package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDto {
    private Long notificationId;
    private String content;
    private String title;
    private Long bookingId;
    private Long paymentTransactionId;
}
