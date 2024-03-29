package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.GoogleUserInfoDto;
import com.example.servicebackend.model.dto.UserDto;
import com.example.servicebackend.model.entity.Partner;
import com.example.servicebackend.model.entity.User;
import com.example.servicebackend.model.mapper.UserMapper;
import com.example.servicebackend.repository.PartnerRepository;
import com.example.servicebackend.repository.UserRepository;
import com.example.servicebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PartnerRepository partnerRepository;

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return UserMapper.INSTANCE.toDto(user);
        }
        return null;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toEntity(userDto);
        User existUser = userRepository.findById(user.getUserId()).orElse(null);
        Partner existPartner = partnerRepository.findById(user.getUserId()).orElse(null);

        if (existUser != null || existPartner != null) {
            return null;
        }
        
        User newUser = userRepository.save(user);
        return UserMapper.INSTANCE.toDto(newUser);
    }

    @Override
    public UserDto addGoogleUserInfor(GoogleUserInfoDto googleUserInfoDto) {
        UserDto userDto = new UserDto();
        userDto.setUserId(googleUserInfoDto.getUid());
        userDto.setUserName(googleUserInfoDto.getDisplayName());
        userDto.setEmail(googleUserInfoDto.getEmail());
        userDto.setImage(googleUserInfoDto.getPhotoURL());
        userDto.setPhoneNumber(googleUserInfoDto.getPhoneNumber());
        userDto.setLocation(googleUserInfoDto.getProviderId());
        
        User user = UserMapper.INSTANCE.toEntity(userDto);

        User newUser = userRepository.save(user);
        return UserMapper.INSTANCE.toDto(newUser);
    }
}
