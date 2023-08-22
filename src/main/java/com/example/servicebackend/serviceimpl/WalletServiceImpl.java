package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.WalletDto;
import com.example.servicebackend.model.entity.Wallet;
import com.example.servicebackend.model.mapper.WalletMapper;
import com.example.servicebackend.repository.WalletRepository;
import com.example.servicebackend.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    public WalletDto addWalletToPartner(WalletDto walletDto) {
        Wallet wallet = walletRepository.save(WalletMapper.INSTANCE.toEntity(walletDto));
        if (wallet != null) {
            return WalletMapper.INSTANCE.toDto(wallet);
        }
        return null;
    }

    @Override
    public WalletDto getWalletByPartnerId(String partnerId) {
        Wallet wallet = walletRepository.findByPartnerId(partnerId);
        if (wallet != null) {
            return WalletMapper.INSTANCE.toDto(wallet);
        }
        return null;
    }
}
