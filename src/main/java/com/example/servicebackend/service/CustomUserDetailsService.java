package com.example.servicebackend.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.servicebackend.model.dto.PartnerDto;
import com.example.servicebackend.model.dto.UserDto;

public interface CustomUserDetailsService {
    UserDetails loadUserByUserId(String userId);

    UserDetails loadUserByUser(UserDto userDto);

    UserDetails loadUserByPartner(PartnerDto partnerDto);
}
