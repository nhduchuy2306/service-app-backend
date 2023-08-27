package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.NotificationDto;
import com.example.servicebackend.model.dto.PartnerDto;
import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.model.dto.WalletDto;
import com.example.servicebackend.service.NotificationService;
import com.example.servicebackend.service.PartnerService;
import com.example.servicebackend.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partners")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService partnerService;
    private final WalletService walletService;
    private final NotificationService notificationService;

    @GetMapping("/{id}/wallet")
    public ResponseEntity<?> getWalletByPartnerId(@PathVariable("id") String id) {
        WalletDto walletDto = walletService.getWalletByPartnerId(id);
        if (walletDto != null) {
            return ResponseEntity.ok(new ResponseDto("Get wallet successfully", walletDto, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Wallet not found", null, HttpStatus.NOT_FOUND.value()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPartnerById(@PathVariable("id") String partnerId) {
        PartnerDto partnerDto = partnerService.getPartnerById(partnerId);
        if (partnerDto != null) {
            return ResponseEntity.ok(partnerDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Partner not found", null, HttpStatus.NOT_FOUND.value()));
    }

    @PostMapping("")
    public ResponseEntity<?> addPartner(@RequestBody PartnerDto partnerDto) {
        PartnerDto newPartner = partnerService.addPartner(partnerDto);
        if (newPartner != null) {
            return ResponseEntity.ok(new ResponseDto("Add partner successfully", newPartner, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/{id}/notifications")
    public ResponseEntity<?> getAllNotificationsByPartnerId(@PathVariable("id") String partnerId) {
        List<NotificationDto> notificationDtos = notificationService.getAllNotificationsByPartnerId(partnerId);
        return ResponseEntity.ok(new ResponseDto("Get all notifications successfully", notificationDtos, HttpStatus.OK.value()));
    }
}
