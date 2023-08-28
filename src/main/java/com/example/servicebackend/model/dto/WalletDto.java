package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {
    private Long walletId;
    private Double money;
    private String status;
    private String partnerId;
    private String userId;
}
