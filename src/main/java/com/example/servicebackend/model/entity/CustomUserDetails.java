package com.example.servicebackend.model.entity;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
    private User user;
    private Partner partner;
    Set<GrantedAuthority> authorities;
    private String role;

    public String getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }

    public Partner getPartner() {
        return partner;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        if (partner != null) {
            return partner.getEmail();
        }
        return user.getEmail();
    }

    @Override
    public String getUsername() {
        if (partner != null) {
            return partner.getPartnerId();
        }
        return user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
