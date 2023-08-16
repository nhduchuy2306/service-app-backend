package com.example.servicebackend.entity;

import com.example.servicebackend.composite_key.ComboAssociationKey;
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
@Table(name = "combo_association")
@IdClass(ComboAssociationKey.class)
public class ComboAssociation implements Serializable {
    @Id
    @Column(name = "combo_id")
    private Long comboId;

    @Id
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "combo_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Combo combo;

    @ManyToOne
    @JoinColumn(name = "request_id", insertable = false, updatable = false)
    @JsonManagedReference
    private ServiceRequest serviceRequest;
}
