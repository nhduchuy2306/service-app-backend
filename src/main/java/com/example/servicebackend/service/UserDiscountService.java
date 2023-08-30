package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.UserDiscountDto;

public interface UserDiscountService {
    UserDiscountDto addUserDiscount(UserDiscountDto userDiscountDto);

    UserDiscountDto getUserDiscountByUserDiscountId(Long userDiscountId);

    UserDiscountDto disableUserDiscount(Long userDiscountId);
}
