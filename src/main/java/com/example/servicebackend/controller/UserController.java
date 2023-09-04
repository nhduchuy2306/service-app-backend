package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.*;
import com.example.servicebackend.service.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User API")
@SecurityRequirement(name = "Authorization")
public class UserController {

    private final UserService userService;
    private final NotificationService notificationService;
    private final BookingService bookingService;
    private final ReportService reportService;
    private final WalletService walletService;
    private final RewardPointService rewardPointService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String userId) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/notifications")
    public ResponseEntity<?> getAllNotificationsByUserId(@PathVariable("id") String userId) {
        List<NotificationDto> notificationDtos = notificationService.getAllNotificationsByUserId(userId);
        return ResponseEntity.ok(notificationDtos);
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<?> getAllBookings(@PathVariable("id") String userId) {
        List<BookingDto> bookingDtos = bookingService.findAllBookingByUserId(userId);
        return ResponseEntity.ok(bookingDtos);
    }

    @GetMapping("/{id}/reports")
    public ResponseEntity<?> getAllReportsByUserId(@PathVariable("id") String userId) {
        List<ReportDto> reportDtos = reportService.getAllReportsByUserId(userId);
        return ResponseEntity.ok(reportDtos);
    }

    @PostMapping("/{id}/reports")
    public ResponseEntity<?> addReport(@PathVariable("id") String userId, @RequestBody ReportDto reportDto) {
        reportDto.setUserId(userId);
        ReportDto res = reportService.addReport(reportDto);
        return ResponseEntity.created(null).body(res);
    }

    @PutMapping("/{id}/wallets/money")
    public ResponseEntity<?> updateMoneyForUser(@PathVariable("id") String userId, @RequestBody WalletDto walletDto) {
        walletDto.setUserId(userId);
        WalletDto res = walletService.updateMoneyForUser(walletDto);
        if (res == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}/reward-points")
    public ResponseEntity<?> getRewardPoint(@PathVariable("id") String userId) {
        RewardPointDto rewardPointDto = rewardPointService.getRewardPoint(userId);
        if (rewardPointDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rewardPointDto);
    }

    @PutMapping("/{id}/reward-points")
    public ResponseEntity<?> updateRewardPoint(@PathVariable("id") String userId, @RequestBody Double rewardPointAmount) {
        RewardPointDto res = rewardPointService.updateRewardPoint(userId, rewardPointAmount);
        if (res == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(res);
    }
}
