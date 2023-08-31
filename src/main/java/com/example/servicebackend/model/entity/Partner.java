package com.example.servicebackend.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "partner")
@AllArgsConstructor
@NoArgsConstructor
public class Partner implements Serializable {
    @Id
    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(unique = true)
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "gender")
    private String gender;

    @Column(name = "image")
    private String image;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Booking> bookings;

    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<PartnerWorkingType> partnerWorkingTypes;

    @OneToOne(mappedBy = "partner", fetch = FetchType.LAZY)
    @JsonBackReference
    private Wallet wallet;
}
