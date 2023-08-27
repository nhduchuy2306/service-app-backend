package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.WalletDto;

public interface WalletService {
    WalletDto addWalletToPartner(WalletDto walletDto);
    WalletDto getWalletByPartnerId(String partnerId);

    WalletDto updateMoneyForPartner(WalletDto walletDto);
}
