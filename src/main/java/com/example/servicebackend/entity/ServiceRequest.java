package com.example.servicebackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "service_request")
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long RequestId;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonManagedReference
    private Service service;

    @OneToMany(mappedBy = "serviceRequest", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ComboAssociation> comboAssociations;

    @OneToOne(mappedBy = "serviceRequest", fetch = FetchType.LAZY)
    @JsonBackReference
    private Booking booking;
}
