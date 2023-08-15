package com.example.servicebackend.entity;

import com.example.servicebackend.enum_type.ComboEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "combo")
public class Combo {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "combo_id")
    private UUID comboId;

    @Column(name = "combo_name")
    private String comboName;

    @Column(name = "combo_description")
    private String comboDescription;

    @Column(name = "combo_price")
    private String comboPrice;

    @Column(name = "combo_type")
    private Enum<ComboEnum> comboType;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
}
