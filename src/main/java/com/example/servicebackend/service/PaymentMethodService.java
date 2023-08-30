package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.PaymentMethodDto;

public interface PaymentMethodService {
    PaymentMethodDto addPaymentMethod(PaymentMethodDto paymentMethodDto);

    PaymentMethodDto removePaymentMethod(PaymentMethodDto paymentMethodDto);
}
