package com.example.servicebackend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partner")
@AllArgsConstructor
@NoArgsConstructor
public class Partner {
    private String partnerId;
    private String partnerName;
    private String email;
    private String location;
}
