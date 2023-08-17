package com.example.servicebackend.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "notification")
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonManagedReference
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "payment_transaction_id")
    @JsonManagedReference
    private PaymentTransaction paymentTransaction;
}
