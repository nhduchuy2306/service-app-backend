package com.example.servicebackend.model.entity;

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
@Table(name = "reward_point")
public class RewardPoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_point_id")
    private Long rewardPointId;

    @Column(name = "reward_point_amount")
    private Double rewardPointAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "rewardPoint", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<UserDiscount> userDiscounts;
}
