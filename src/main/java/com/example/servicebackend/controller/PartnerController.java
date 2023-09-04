package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.*;
import com.example.servicebackend.service.BookingService;
import com.example.servicebackend.service.NotificationService;
import com.example.servicebackend.service.PartnerService;
import com.example.servicebackend.service.WalletService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partners")
@RequiredArgsConstructor
@Tag(name = "Partner API")
@SecurityRequirement(name = "Authorization")
public class PartnerController {

    private final PartnerService partnerService;
    private final WalletService walletService;
    private final NotificationService notificationService;
    private final BookingService bookingService;

    @GetMapping("/{id}/wallet")
    public ResponseEntity<?> getWalletByPartnerId(@PathVariable("id") String id) {
        WalletDto walletDto = walletService.getWalletByPartnerId(id);
        if (walletDto != null) {
            return ResponseEntity.ok(walletDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePartner(@PathVariable("id") String partnerId, @RequestBody PartnerDto partnerDto) {
        partnerDto.setPartnerId(partnerId);
        PartnerDto res = partnerService.updatePartner(partnerDto);
        if (res == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPartnerById(@PathVariable("id") String partnerId) {
        PartnerDto partnerDto = partnerService.getPartnerById(partnerId);
        if (partnerDto != null) {
            return ResponseEntity.ok(partnerDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/notifications")
    public ResponseEntity<?> getAllNotificationsByPartnerId(@PathVariable("id") String partnerId) {
        List<NotificationDto> notificationDtos = notificationService.getAllNotificationsByPartnerId(partnerId);
        if(notificationDtos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notificationDtos);
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<?> getAllBookings(@PathVariable("id") String partnerId) {
        List<BookingDto> bookingDtos = bookingService.findAllBookingByPartnerId(partnerId);
        if(bookingDtos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookingDtos);
    }

    @PutMapping("/{id}/wallets/money")
    public ResponseEntity<?> updateMoneyForPartner(@PathVariable("id") String partnerId, @RequestBody WalletDto walletDto) {
        walletDto.setPartnerId(partnerId);
        WalletDto res = walletService.updateMoneyForPartner(walletDto);
        if (res == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }
}
