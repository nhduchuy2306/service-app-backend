package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.RewardPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardPointRepository extends JpaRepository<RewardPoint, Long> {

    @Query("SELECT r FROM RewardPoint r WHERE r.user.userId = :userId")
    RewardPoint findRewardPointByUserId(String userId);
}
