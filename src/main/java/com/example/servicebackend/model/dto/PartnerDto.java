package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartnerDto {
    private String partnerId;
    private String partnerName;
    private String email;
    private String location;
    private String gender;
    private String image;
    private String phoneNumber;
    private String status;
}
