package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.AuthenticationResponseDto;
import com.example.servicebackend.model.dto.GoogleUserInfoDto;

public interface AuthenticationService {
    AuthenticationResponseDto loginGoogleForUser(GoogleUserInfoDto googleUserInfoDto);
    AuthenticationResponseDto loginGoogleForPartner(GoogleUserInfoDto googleUserInfoDto);
}
