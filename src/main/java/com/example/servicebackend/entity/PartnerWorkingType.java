package com.example.servicebackend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.servicebackend.composite_key.PartnerWorkingTypeId;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "partner_working_type")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PartnerWorkingTypeId.class)
public class PartnerWorkingType implements Serializable {
    @Id
    @Column(name = "partner_id")
    private String partnerId;

    @Id
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "partner_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Service service;
}
