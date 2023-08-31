package com.example.servicebackend.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.servicebackend.configuration.jwt.JwtTokenProvider;
import com.example.servicebackend.model.dto.AuthenticationResponseDto;
import com.example.servicebackend.model.dto.GoogleUserInfoDto;
import com.example.servicebackend.model.entity.CustomUserDetails;
import com.example.servicebackend.model.entity.Partner;
import com.example.servicebackend.model.entity.User;
import com.example.servicebackend.repository.PartnerRepository;
import com.example.servicebackend.repository.UserRepository;
import com.example.servicebackend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PartnerRepository partnerRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthenticationResponseDto loginGoogle(GoogleUserInfoDto googleUserInfoDto) {
        String uid = googleUserInfoDto.getUid();

        User user = userRepository.findById(uid).orElse(null);
        Partner partner = partnerRepository.findById(uid).orElse(null);
        CustomUserDetails customUserDetails = null;
        String accessToken = "";
        String refreshToken = "";

        if(user != null) {
            customUserDetails = new CustomUserDetails(user, null, null, "ROLE_USER");
            accessToken = jwtTokenProvider.generateAccessToken(customUserDetails);
            refreshToken = jwtTokenProvider.generateRefreshToken(customUserDetails);
        }
        else{
            customUserDetails = new CustomUserDetails(null, partner, null, "ROLE_PARTNER");
            accessToken = jwtTokenProvider.generateAccessToken(customUserDetails);
            refreshToken = jwtTokenProvider.generateRefreshToken(customUserDetails);
        }

        return new AuthenticationResponseDto(accessToken, refreshToken);

    }
    
}
