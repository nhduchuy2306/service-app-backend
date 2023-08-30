package com.example.servicebackend.model.entity;

import com.example.servicebackend.model.enumtype.UserDiscountEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "reward_point_id")
    @JsonManagedReference
    private RewardPoint rewardPoint;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserDiscountEnum status;

    @OneToMany(mappedBy = "userDiscount", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<UserDiscountAssociation> userDiscountAssociations;
}
