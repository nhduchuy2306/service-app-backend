package com.example.servicebackend.model.entity;

import com.example.servicebackend.model.compositekey.UserDiscountAssociationId;
import com.example.servicebackend.model.enumtype.UserDiscountAssociationEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_discount_association")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserDiscountAssociationId.class)
public class UserDiscountAssociation {

    @Id
    @Column(name = "request_id")
    private Long requestId;

    @Id
    @Column(name = "user_discount_id")
    private Long userDiscountId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserDiscountAssociationEnum status;

    @ManyToOne
    @JoinColumn(name = "request_id", insertable = false, updatable = false)
    @JsonManagedReference
    private ServiceRequest serviceRequest;

    @ManyToOne
    @JoinColumn(name = "user_discount_id", insertable = false, updatable = false)
    @JsonManagedReference
    private UserDiscount userDiscount;
}
