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
        Wallet wallet = WalletMapper.INSTANCE.toEntity(walletDto);
        wallet.setUser(null);
        Wallet newWallet = walletRepository.save(wallet);
        if (newWallet != null) {
            return WalletMapper.INSTANCE.toDto(newWallet);
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

    @Override
    public WalletDto updateMoneyForPartner(WalletDto walletDto) {
        Wallet wallet = walletRepository.findByPartnerId(walletDto.getPartnerId());
        if (wallet != null) {
            wallet.setMoney(walletDto.getMoney());
            walletRepository.save(wallet);
            return WalletMapper.INSTANCE.toDto(wallet);
        }
        return null;
    }

    @Override
    public WalletDto addWalletToUser(WalletDto walletDto) {
        Wallet wallet = WalletMapper.INSTANCE.toEntity(walletDto);
        wallet.setPartner(null);
        Wallet newWallet = walletRepository.save(wallet);
        if (newWallet != null) {
            return WalletMapper.INSTANCE.toDto(newWallet);
        }
        return null;
    }

    @Override
    public WalletDto updateMoneyForUser(WalletDto walletDto) {
        Wallet wallet = walletRepository.findByUserId(walletDto.getUserId());
        if (wallet != null) {
            wallet.setMoney(walletDto.getMoney());
            walletRepository.save(wallet);
            return WalletMapper.INSTANCE.toDto(wallet);
        }
        return null;
    }
}
