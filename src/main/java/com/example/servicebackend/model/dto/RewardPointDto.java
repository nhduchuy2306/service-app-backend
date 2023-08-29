package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RewardPointDto {
    private Long rewardPointId;
    private Double rewardPointAmount;
    private String userId;
}
