package com.example.servicebackend.serviceimpl;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.servicebackend.model.dto.PartnerDto;
import com.example.servicebackend.model.dto.UserDto;
import com.example.servicebackend.model.entity.CustomUserDetails;
import com.example.servicebackend.model.entity.Partner;
import com.example.servicebackend.model.entity.User;
import com.example.servicebackend.model.mapper.PartnerMapper;
import com.example.servicebackend.model.mapper.UserMapper;
import com.example.servicebackend.repository.PartnerRepository;
import com.example.servicebackend.repository.UserRepository;
import com.example.servicebackend.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService, UserDetailsService {

    private final UserRepository userRepository;
    private final PartnerRepository partnerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserId(username);
        Optional<Partner> partner = partnerRepository.findByPartnerId(username);
        String role = "";

        if (user.isEmpty()) {
            if (partner.isEmpty()) {
                throw new UsernameNotFoundException(username);
            } else {
                role = "Partner";
            }
        } else {
            role = "User";
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return new CustomUserDetails(user.orElse(null), partner.orElse(null), authorities, role);
    }

    @Override
    public UserDetails loadUserByUserId(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        Optional<Partner> partner = partnerRepository.findByPartnerId(userId);
        String role = "";

        if (user.isEmpty()) {
            if (partner.isEmpty()) {
                return new CustomUserDetails(null, null, null, null);
            } else {
                if (partner.get().getPartnerId().equals(userId)) {
                    role = "Partner";
                } else {
                    throw new InvalidParameterException("Your email account has been blocked");
                }
            }
        } else {
            if (user.get().getUserId().equals(userId)) {
                role = "User";
            } else {
                throw new InvalidParameterException("Your email account has been blocked");
            }
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return new CustomUserDetails(user.orElse(null), partner.orElse(null), authorities, role);
    }

    @Override
    public UserDetails loadUserByUser(UserDto userDto) {
        String role = "User";
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        User user = UserMapper.INSTANCE.toEntity(userDto);

        return new CustomUserDetails(user, null, authorities, role);
    }

    @Override
    public UserDetails loadUserByPartner(PartnerDto partnerDto) {
        String role = "Partner";
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        Partner partner = PartnerMapper.INSTANCE.toEntity(partnerDto);

        return new CustomUserDetails(null, partner, authorities, role);
    }

}