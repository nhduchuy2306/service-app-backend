package com.example.servicebackend.model.dto;

import com.example.servicebackend.model.entity.DiscountExchange;
import com.example.servicebackend.model.entity.PaymentTransaction;
import com.example.servicebackend.model.entity.RewardPoint;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDiscountDto {
    private Long userDiscountId;
    private Double pointEarned;
    private Long discountExchangeId;
    private Long paymentTransactionId;
    private Long rewardPointId;
}
