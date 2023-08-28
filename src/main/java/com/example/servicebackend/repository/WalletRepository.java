package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    @Query("SELECT w FROM Wallet w WHERE w.partner.partnerId = :partnerId")
    Wallet findByPartnerId(String partnerId);

    @Query("SELECT w FROM Wallet w WHERE w.user.userId = :userId")
    Wallet findByUserId(String userId);
}
