package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.DiscountExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountExchangeRepository extends JpaRepository<DiscountExchange, Long> {

    @Query("SELECT d FROM DiscountExchange d WHERE d.status = 'ACTIVE'")
    List<DiscountExchange> findAll();
}
