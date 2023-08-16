package com.example.servicebackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user_discount")
public class UserDiscount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_discount_id")
    private Long userDiscountId;

    @Column(name = "point_earned")
    private Double pointEarned;

    @ManyToOne
    @JoinColumn(name = "discount_exchange_id")
    @JsonManagedReference
    private DiscountExchange discountExchange;

    @OneToOne(mappedBy = "userDiscount", fetch = FetchType.LAZY)
    @JsonManagedReference
    private PaymentTransaction paymentTransaction;

    @ManyToOne
    @JoinColumn(name = "reward_point_id", insertable = false, updatable = false)
    @JsonManagedReference
    private RewardPoint rewardPoint;
}
