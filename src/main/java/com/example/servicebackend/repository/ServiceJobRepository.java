package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.ServiceJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceJobRepository extends JpaRepository<ServiceJob, Long> {
}
