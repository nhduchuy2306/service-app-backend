package com.example.servicebackend.repository;

import com.example.servicebackend.composite_key.ComboAssociationId;
import com.example.servicebackend.entity.ComboAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboAssociationRepository extends JpaRepository<ComboAssociation, ComboAssociationId> {
}
