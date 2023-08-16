package com.example.servicebackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Report> reports;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @JsonManagedReference
    private Partner partner;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Notification> notifications;

    @OneToOne(mappedBy = "booking", fetch = FetchType.LAZY)
    @JsonBackReference
    private PaymentTransaction paymentTransaction;

    @OneToOne
    @JoinColumn(name = "request_id")
    @JsonManagedReference
    private ServiceRequest serviceRequest;
}
