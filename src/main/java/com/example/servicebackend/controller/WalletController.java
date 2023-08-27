package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.model.dto.WalletDto;
import com.example.servicebackend.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
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
            return ResponseEntity.ok(new ResponseDto("Add wallet successfully", newWallet, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Add wallet failed", null, HttpStatus.BAD_REQUEST.value()));
    }

    @PostMapping("/money")
    public ResponseEntity<?> updateMoneyForPartner(@RequestBody WalletDto walletDto) {
        WalletDto newWallet = walletService.updateMoneyForPartner(walletDto);
        if (newWallet != null) {
            return ResponseEntity.ok(new ResponseDto("Update money successfully", newWallet, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Update money failed", null, HttpStatus.BAD_REQUEST.value()));
    }
}
