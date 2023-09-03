package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.GoogleUserInfoDto;
import com.example.servicebackend.model.dto.PartnerDto;
import com.example.servicebackend.model.entity.Partner;
import com.example.servicebackend.model.entity.User;
import com.example.servicebackend.model.mapper.PartnerMapper;
import com.example.servicebackend.repository.PartnerRepository;
import com.example.servicebackend.repository.UserRepository;
import com.example.servicebackend.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;
    private final UserRepository userRepository;

    @Override
    public PartnerDto getPartnerById(String partnerId) {
        Partner partner = partnerRepository.findById(partnerId).orElse(null);
        if(partner != null){
            return PartnerMapper.INSTANCE.toDto(partner);
        }
        return null;
    }

    @Override
    public PartnerDto addPartner(PartnerDto partnerDto) {
        Partner partner = PartnerMapper.INSTANCE.toEntity(partnerDto);
        Partner existPartner = partnerRepository.findById(partner.getPartnerId()).orElse(null);
        User existUser = userRepository.findById(partner.getPartnerId()).orElse(null);

        if(existPartner != null || existUser != null){
            return null;
        }

        Partner newPartner = partnerRepository.save(partner);
        return PartnerMapper.INSTANCE.toDto(newPartner);
    }

    @Override
    public PartnerDto addGoogleUserInfor(GoogleUserInfoDto googleUserInfoDto) {
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setPartnerId(googleUserInfoDto.getUid());
        partnerDto.setPartnerName(googleUserInfoDto.getDisplayName());
        partnerDto.setEmail(googleUserInfoDto.getEmail());
        partnerDto.setImage(googleUserInfoDto.getPhotoURL());
        partnerDto.setPhoneNumber(googleUserInfoDto.getPhoneNumber());
        partnerDto.setLocation(googleUserInfoDto.getProviderId());

        Partner partner = PartnerMapper.INSTANCE.toEntity(partnerDto);
        Partner newPartner = partnerRepository.save(partner);
        return PartnerMapper.INSTANCE.toDto(newPartner);
    }

    @Override
    public PartnerDto updatePartner(PartnerDto partnerDto) {
        Partner existPartner = partnerRepository.findById(partnerDto.getPartnerId()).orElse(null);
        if(partnerDto.getPartnerName() == null){
            partnerDto.setPartnerName(existPartner.getPartnerName());
        }
        if(partnerDto.getEmail() == null){
            partnerDto.setEmail(existPartner.getEmail());
        }
        if(partnerDto.getImage() == null){
            partnerDto.setImage(existPartner.getImage());
        }
        if(partnerDto.getPhoneNumber() == null){
            partnerDto.setPhoneNumber(existPartner.getPhoneNumber());
        }
        if(partnerDto.getLocation() == null){
            partnerDto.setLocation(existPartner.getLocation());
        }
        if(partnerDto.getGender() == null){
            partnerDto.setGender(existPartner.getGender());
        }
        if(partnerDto.getStatus() == null){
            partnerDto.setStatus(existPartner.getStatus());
        }
        Partner partner = PartnerMapper.INSTANCE.toEntity(partnerDto);
        Partner updatePartner = partnerRepository.save(partner);
        return PartnerMapper.INSTANCE.toDto(updatePartner);
    }
}
