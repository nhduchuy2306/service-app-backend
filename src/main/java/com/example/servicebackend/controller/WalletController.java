package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.WalletDto;
import com.example.servicebackend.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/add-to-partner")
    public ResponseEntity<?> addWalletToPartner(@RequestBody WalletDto walletDto) {
        WalletDto newWallet = walletService.addWalletToPartner(walletDto);
        if (newWallet != null) {
            return ResponseEntity.ok(newWallet);
        }
        return ResponseEntity.badRequest().build();
    }
}
