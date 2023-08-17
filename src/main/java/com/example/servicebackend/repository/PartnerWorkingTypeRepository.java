package com.example.servicebackend.repository;

import com.example.servicebackend.composite_key.PartnerWorkingTypeId;
import com.example.servicebackend.entity.PartnerWorkingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerWorkingTypeRepository extends JpaRepository<PartnerWorkingType, PartnerWorkingTypeId> {
}
