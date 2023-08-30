package com.example.servicebackend.model.dto;

import com.example.servicebackend.model.enumtype.PaymentMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentMethodDto {
    private Long paymentMethodId;
    private String paymentMethodName;
    private String description;
    private String paymentMethodType;
    private String userId;
    private PaymentMethodEnum status;
}
