package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.RewardPointDto;
import com.example.servicebackend.model.entity.RewardPoint;
import com.example.servicebackend.model.mapper.RewardPointMapper;
import com.example.servicebackend.repository.RewardPointRepository;
import com.example.servicebackend.service.RewardPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RewardPointServiceImpl implements RewardPointService {

    private final RewardPointRepository rewardPointRepository;

    @Override
    public RewardPointDto updateRewardPoint(String userId, Double rewardPointAmount) {
        RewardPoint rewardPoint = rewardPointRepository.findRewardPointByUserId(userId);
        if (rewardPoint != null) {
            Double total = rewardPoint.getRewardPointAmount() + rewardPointAmount;
            rewardPoint.setRewardPointAmount(total);
            RewardPoint updateRewardPoint = rewardPointRepository.save(rewardPoint);
            if (updateRewardPoint != null) {
                return RewardPointMapper.INSTANCE.toDto(updateRewardPoint);
            }
        }
        return null;
    }

    @Override
    public RewardPointDto getRewardPoint(String userId) {
        RewardPoint rewardPoint = rewardPointRepository.findRewardPointByUserId(userId);
        if (rewardPoint != null) {
            return RewardPointMapper.INSTANCE.toDto(rewardPoint);
        }
        return null;
    }

    @Override
    public RewardPointDto initRewardPoint(String userId) {
        RewardPointDto rewardPointDto = new RewardPointDto();
        rewardPointDto.setUserId(userId);
        rewardPointDto.setRewardPointAmount(0.0);
        RewardPoint rewardPoint = rewardPointRepository.save(RewardPointMapper.INSTANCE.toEntity(rewardPointDto));

        if (rewardPoint != null) {
            return RewardPointMapper.INSTANCE.toDto(rewardPoint);
        }
        return null;
    }

}
