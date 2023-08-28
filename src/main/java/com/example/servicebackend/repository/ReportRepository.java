package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("SELECT r FROM Report r WHERE r.user.userId = :userId")
    List<Report> findAllByUserId(String userId);
}
