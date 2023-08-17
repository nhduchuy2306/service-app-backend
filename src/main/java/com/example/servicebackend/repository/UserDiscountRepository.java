package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.UserDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDiscountRepository extends JpaRepository<UserDiscount, Long> {
}
