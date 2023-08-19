package com.example.servicebackend.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "service_job")
public class ServiceJob implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "serviceJob", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ServiceRequest> serviceRequests;

    @OneToMany(mappedBy = "serviceJob", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<PartnerWorkingType> partnerWorkingTypes;
}
