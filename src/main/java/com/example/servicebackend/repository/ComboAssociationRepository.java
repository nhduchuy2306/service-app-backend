package com.example.servicebackend.repository;

import com.example.servicebackend.model.compositekey.ComboAssociationId;
import com.example.servicebackend.model.entity.ComboAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboAssociationRepository extends JpaRepository<ComboAssociation, ComboAssociationId> {
}
