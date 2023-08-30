package com.example.servicebackend.model.dto;

import com.example.servicebackend.model.enumtype.UserDiscountEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDiscountDto {
    private Long userDiscountId;
    private Double pointEarned;
    private Long discountExchangeId;
    private Long paymentTransactionId;
    private Long rewardPointId;
    private UserDiscountEnum status;
}
