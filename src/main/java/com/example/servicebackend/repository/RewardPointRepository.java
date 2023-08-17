package com.example.servicebackend.repository;

import com.example.servicebackend.entity.RewardPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardPointRepository extends JpaRepository<RewardPoint, Long> {
}
