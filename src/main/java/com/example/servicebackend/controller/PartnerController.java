package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.*;
import com.example.servicebackend.service.BookingService;
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
    private final BookingService bookingService;

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

    @PostMapping("/auth/google")
    public ResponseEntity<?> addGoogleUserInfor(@RequestBody GoogleUserInfoDto googleUserInfoDto) {
        PartnerDto partnerDto = partnerService.getPartnerById(googleUserInfoDto.getUid());
        if (partnerDto != null) {
            // Partner already exists
            return ResponseEntity.ok(new ResponseDto("Partner already exists", partnerDto, HttpStatus.OK.value()));
        } else {
            // User not exists
            PartnerDto res = partnerService.addGoogleUserInfor(googleUserInfoDto);
            if (res == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Add partner failed", null, HttpStatus.BAD_REQUEST.value()));
            }
            // Create wallet
            WalletDto walletDto = new WalletDto();
            walletDto.setUserId(res.getPartnerId());
            walletDto.setMoney(0.0);
            walletDto.setStatus("ACTIVE");
            walletDto.setUserId(null);
            walletService.addWalletToUser(walletDto);

            return ResponseEntity.created(null).body(new ResponseDto("Add partner successfully", res, HttpStatus.CREATED.value()));
        }
    }

    @GetMapping("/{id}/notifications")
    public ResponseEntity<?> getAllNotificationsByPartnerId(@PathVariable("id") String partnerId) {
        List<NotificationDto> notificationDtos = notificationService.getAllNotificationsByPartnerId(partnerId);
        return ResponseEntity.ok(new ResponseDto("Get all notifications successfully", notificationDtos, HttpStatus.OK.value()));
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<?> getAllBookings(@PathVariable("id") String partnerId) {
        List<BookingDto> bookingDtos = bookingService.findAllBookingByPartnerId(partnerId);
        return ResponseEntity.ok(new ResponseDto("Get all bookings successfully", bookingDtos, HttpStatus.OK.value()));
    }

    @PutMapping("/{id}/wallets/money")
    public ResponseEntity<?> updateMoneyForPartner(@PathVariable("id") String partnerId, @RequestBody WalletDto walletDto) {
        walletDto.setPartnerId(partnerId);
        WalletDto res = walletService.updateMoneyForPartner(walletDto);
        if (res == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Update money failed", null, HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.ok(new ResponseDto("Update money successfully", res, HttpStatus.OK.value()));
    }
}
