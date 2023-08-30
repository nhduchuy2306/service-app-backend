package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.UserDiscountDto;
import com.example.servicebackend.model.entity.UserDiscount;
import com.example.servicebackend.model.enumtype.UserDiscountEnum;
import com.example.servicebackend.model.mapper.UserDiscountMapper;
import com.example.servicebackend.repository.UserDiscountRepository;
import com.example.servicebackend.service.UserDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDiscountServiceImpl implements UserDiscountService {

    private final UserDiscountRepository userDiscountRepository;

    @Override
    public UserDiscountDto addUserDiscount(UserDiscountDto userDiscountDto) {
        userDiscountDto.setStatus(UserDiscountEnum.ACTIVE);
        UserDiscount userDiscount = UserDiscountMapper.INSTANCE.toEntity(userDiscountDto);
        UserDiscount newUserDiscount = userDiscountRepository.save(userDiscount);
        if (newUserDiscount != null)
            return UserDiscountMapper.INSTANCE.toDto(newUserDiscount);
        return null;
    }

    @Override
    public UserDiscountDto getUserDiscountByUserDiscountId(Long userDiscountId) {
        UserDiscount userDiscount = userDiscountRepository.findById(userDiscountId).orElse(null);
        if (userDiscount != null)
            return UserDiscountMapper.INSTANCE.toDto(userDiscount);
        return null;
    }

    @Override
    public UserDiscountDto disableUserDiscount(Long userDiscountId) {
        UserDiscount userDiscount = userDiscountRepository.findById(userDiscountId).orElse(null);
        if (userDiscount != null) {
            userDiscount.setStatus(UserDiscountEnum.INACTIVE);
            UserDiscount updateUserDiscount = userDiscountRepository.save(userDiscount);
            if (updateUserDiscount != null)
                return UserDiscountMapper.INSTANCE.toDto(updateUserDiscount);
        }
        return null;
    }
}
