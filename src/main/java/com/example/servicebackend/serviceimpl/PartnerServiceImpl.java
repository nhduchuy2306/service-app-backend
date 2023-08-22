package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.PartnerDto;
import com.example.servicebackend.model.entity.Partner;
import com.example.servicebackend.model.mapper.PartnerMapper;
import com.example.servicebackend.repository.PartnerRepository;
import com.example.servicebackend.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

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
        Partner newPartner = partnerRepository.save(partner);
        return PartnerMapper.INSTANCE.toDto(newPartner);
    }
}
