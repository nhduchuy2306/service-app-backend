package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.RewardPointDto;

public interface RewardPointService {
    RewardPointDto updateRewardPoint(String userId, Double rewardPointAmount);

    RewardPointDto getRewardPoint(String userId);

    RewardPointDto initRewardPoint(String userId);
}
