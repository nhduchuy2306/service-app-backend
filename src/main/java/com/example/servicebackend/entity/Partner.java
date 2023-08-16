package com.example.servicebackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "partner")
@AllArgsConstructor
@NoArgsConstructor
public class Partner implements Serializable {
    @Id
    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Booking> bookings;
}
