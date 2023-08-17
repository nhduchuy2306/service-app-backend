package com.example.servicebackend.model.entity;

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
@Table(name = "report")
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long reportId;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonManagedReference
    private Booking booking;
}
