package com.example.servicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.servicebackend.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}
