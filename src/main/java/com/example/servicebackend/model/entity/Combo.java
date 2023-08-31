package com.example.servicebackend.model.entity;

import com.example.servicebackend.model.enumtype.ComboEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "combo")
public class Combo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "combo_id")
    private Long comboId;

    @Column(name = "combo_name")
    private String comboName;

    @Column(name = "combo_description")
    private String comboDescription;

    @Column(name = "combo_price")
    private String comboPrice;

    @Column(name = "combo_type")
    @Enumerated(EnumType.STRING)
    private ComboEnum comboType;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(mappedBy = "combo", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ComboAssociation> comboAssociations;
}
