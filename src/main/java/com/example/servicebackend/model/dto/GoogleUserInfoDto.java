package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoogleUserInfoDto {
    private String displayName;
    private String email;
    private String phoneNumber;
    private String photoURL;
    private String providerId;
    private String uid;
}
