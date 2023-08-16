package com.example.servicebackend.entity;

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
@Table(name = "discount_exchange")
public class DiscountExchange implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_exchange_id")
    private Long discountExchangeId;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "discountExchange", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<UserDiscount> userDiscounts;
}
