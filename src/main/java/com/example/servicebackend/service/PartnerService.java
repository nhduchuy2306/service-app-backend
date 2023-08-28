package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.GoogleUserInfoDto;
import com.example.servicebackend.model.dto.PartnerDto;

public interface PartnerService {
    PartnerDto getPartnerById(String partnerId);

    PartnerDto addPartner(PartnerDto partnerDto);

    PartnerDto addGoogleUserInfor(GoogleUserInfoDto googleUserInfoDto);
}
