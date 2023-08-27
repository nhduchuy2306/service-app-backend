package com.example.servicebackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private String userId;
    private String userName;
    private String email;
    private String location;
    private String image;
    private String phoneNumber;
}
