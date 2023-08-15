package com.example.servicebackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_method")
@Data
public class PaymentMethod {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="payment_method_id")
    private String paymentMethodId;

    @Column(name="payment_method_name")
    private String paymentMethodName;

    @Column(name="description")
    private String description;

    @Column(name="payment_method_type")
    private String paymentMethodType;
}
