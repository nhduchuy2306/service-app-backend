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
    public AuthenticationResponseDto loginGoogleForUser(GoogleUserInfoDto googleUserInfoDto) {
        String uid = googleUserInfoDto.getUid();

        User user = userRepository.findById(uid).orElse(null);
        Partner partner = partnerRepository.findById(uid).orElse(null);

        if (partner != null)
            return null;

        CustomUserDetails customUserDetails = new CustomUserDetails(user, null, null, "ROLE_USER");
        String accessToken = jwtTokenProvider.generateAccessToken(customUserDetails);
        String refreshToken = jwtTokenProvider.generateRefreshToken(customUserDetails);

        return new AuthenticationResponseDto(accessToken, refreshToken);
    }

    @Override
    public AuthenticationResponseDto loginGoogleForPartner(GoogleUserInfoDto googleUserInfoDto) {
        String uid = googleUserInfoDto.getUid();

        User user = userRepository.findById(uid).orElse(null);
        Partner partner = partnerRepository.findById(uid).orElse(null);

        if (user != null)
            return null;

        CustomUserDetails customUserDetails = new CustomUserDetails(null, partner, null, "ROLE_PARTNER");
        String accessToken = jwtTokenProvider.generateAccessToken(customUserDetails);
        String refreshToken = jwtTokenProvider.generateRefreshToken(customUserDetails);

        return new AuthenticationResponseDto(accessToken, refreshToken);
    }

}
