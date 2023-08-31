package com.example.servicebackend.model.dto;

import com.example.servicebackend.model.enumtype.PaymentTransactionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentTransactionDto {
    private Long paymentTransactionId;
    private String paymentTransactionAmount;
    private Long paymentMethodId;
    private Long bookingId;
    private PaymentTransactionEnum status;
}
