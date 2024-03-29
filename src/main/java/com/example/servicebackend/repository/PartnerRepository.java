package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.Partner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, String> {
    Optional<Partner> findByPartnerId(String partnerId);
}
