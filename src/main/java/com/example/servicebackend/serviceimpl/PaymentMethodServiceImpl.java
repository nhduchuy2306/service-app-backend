package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.PaymentMethodDto;
import com.example.servicebackend.model.entity.PaymentMethod;
import com.example.servicebackend.model.enumtype.PaymentMethodEnum;
import com.example.servicebackend.model.mapper.PaymentMethodMapper;
import com.example.servicebackend.repository.PaymentMethodRepository;
import com.example.servicebackend.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethodDto addPaymentMethod(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.toEntity(paymentMethodDto);
        PaymentMethod newPaymentMethod = paymentMethodRepository.save(paymentMethod);
        if (newPaymentMethod != null) {
            return PaymentMethodMapper.INSTANCE.toDto(newPaymentMethod);
        }
        return null;
    }

    @Override
    public PaymentMethodDto removePaymentMethod(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.toEntity(paymentMethodDto);
        paymentMethod.setStatus(PaymentMethodEnum.INACTIVE);
        PaymentMethod updatePaymentMethod = paymentMethodRepository.save(paymentMethod);

        if (updatePaymentMethod != null) {
            return PaymentMethodMapper.INSTANCE.toDto(updatePaymentMethod);
        }
        return null;
    }
}
