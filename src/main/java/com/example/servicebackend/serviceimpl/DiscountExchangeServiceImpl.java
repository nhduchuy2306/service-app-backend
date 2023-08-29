package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.DiscountExchangeDto;
import com.example.servicebackend.model.entity.DiscountExchange;
import com.example.servicebackend.model.enumtype.DiscountExchangeEnum;
import com.example.servicebackend.model.mapper.DiscountExchangeMapper;
import com.example.servicebackend.repository.DiscountExchangeRepository;
import com.example.servicebackend.service.DiscountExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiscountExchangeServiceImpl implements DiscountExchangeService {

    private final DiscountExchangeRepository discountExchangeRepository;

    @Override
    public DiscountExchangeDto addDiscountExchange(DiscountExchangeDto discountExchangeDto) {
        discountExchangeDto.setStatus(DiscountExchangeEnum.ACTIVE);
        DiscountExchange discountExchange = DiscountExchangeMapper.INSTANCE.toEntity(discountExchangeDto);

        DiscountExchange newDiscountExchange = discountExchangeRepository.save(discountExchange);

        if(newDiscountExchange != null) {
            return DiscountExchangeMapper.INSTANCE.toDto(newDiscountExchange);
        }
        return null;
    }

    @Override
    public List<DiscountExchangeDto> getAllDiscountExchange() {
        List<DiscountExchange> discountExchanges = discountExchangeRepository.findAll();
        if (discountExchanges != null) {
            return discountExchanges.stream().map(DiscountExchangeMapper.INSTANCE::toDto).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public DiscountExchangeDto removeDiscountExchange(Long discountExchangeId) {
        DiscountExchange discountExchange = discountExchangeRepository.findById(discountExchangeId).orElse(null);
        if(discountExchange != null) {
            discountExchange.setStatus(DiscountExchangeEnum.INACTIVE);
            DiscountExchange newDiscountExchange = discountExchangeRepository.save(discountExchange);
            if(newDiscountExchange != null) {
                return DiscountExchangeMapper.INSTANCE.toDto(newDiscountExchange);
            }
        }
        return null;
    }


}
