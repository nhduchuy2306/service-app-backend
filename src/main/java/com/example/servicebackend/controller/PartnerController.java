package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.PartnerDto;
import com.example.servicebackend.model.dto.WalletDto;
import com.example.servicebackend.service.PartnerService;
import com.example.servicebackend.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/partner")
@RequiredArgsConstructor
public class PartnerController {
    private final PartnerService partnerService;
    private final WalletService walletService;

    @GetMapping("/{id}/wallet")
    public ResponseEntity<?> getWalletByPartnerId(@PathVariable("id") String id) {
        WalletDto walletDto = walletService.getWalletByPartnerId(id);
        if (walletDto != null) {
            return ResponseEntity.ok(walletDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPartnerById(@PathVariable String partnerId) {
        PartnerDto partnerDto = partnerService.getPartnerById(partnerId);
        if (partnerDto != null) {
            return ResponseEntity.ok(partnerDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> addPartner(@RequestBody PartnerDto partnerDto) {
        PartnerDto newPartner = partnerService.addPartner(partnerDto);
        if (newPartner != null) {
            return ResponseEntity.ok(newPartner);
        }
        return ResponseEntity.badRequest().build();
    }
}
