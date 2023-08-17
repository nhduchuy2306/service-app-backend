package com.example.servicebackend.repository;

import com.example.servicebackend.entity.DiscountExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountExchangeRepository extends JpaRepository<DiscountExchange, Long> {
}
