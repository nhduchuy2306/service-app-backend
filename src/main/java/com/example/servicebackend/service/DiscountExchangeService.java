package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.DiscountExchangeDto;

import java.util.List;

public interface DiscountExchangeService {
    DiscountExchangeDto addDiscountExchange(DiscountExchangeDto discountExchangeDto);

    List<DiscountExchangeDto> getAllDiscountExchange();

    DiscountExchangeDto removeDiscountExchange(Long discountExchangeId);
}
