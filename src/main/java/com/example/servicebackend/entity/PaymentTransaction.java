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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_transaction_id")
    private Long paymentTransactionId;

    @Column(name = "payment_transaction_amount")
    private String paymentTransactionAmount;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    @JsonManagedReference
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "user_discount_id")
    @JsonManagedReference
    private UserDiscount userDiscount;

    @OneToMany(mappedBy = "paymentTransaction")
    @JsonBackReference
    private List<Notification> notifications;

    @OneToOne
    @JoinColumn(name = "booking_id")
    @JsonManagedReference
    private Booking booking;
}
