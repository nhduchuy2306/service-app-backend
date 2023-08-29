package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.*;
import com.example.servicebackend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
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
            return ResponseEntity.ok(new ResponseDto("Get user successfully", userDto, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("User not found", null, HttpStatus.NOT_FOUND.value()));
    }

    @GetMapping("/{id}/notifications")
    public ResponseEntity<?> getAllNotificationsByUserId(@PathVariable("id") String userId) {
        List<NotificationDto> notificationDtos = notificationService.getAllNotificationsByUserId(userId);
        return ResponseEntity.ok(new ResponseDto("Get all notifications successfully", notificationDtos, HttpStatus.OK.value()));
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<?> getAllBookings(@PathVariable("id") String userId) {
        List<BookingDto> bookingDtos = bookingService.findAllBookingByUserId(userId);
        return ResponseEntity.ok(new ResponseDto("Get all bookings successfully", bookingDtos, HttpStatus.OK.value()));
    }

    @GetMapping("/{id}/reports")
    public ResponseEntity<?> getAllReportsByUserId(@PathVariable("id") String userId) {
        List<ReportDto> reportDtos = reportService.getAllReportsByUserId(userId);
        return ResponseEntity.ok(new ResponseDto("Get all reports successfully", reportDtos, HttpStatus.OK.value()));
    }

    @PostMapping("/{id}/reports")
    public ResponseEntity<?> addReport(@PathVariable("id") String userId, @RequestBody ReportDto reportDto) {
        reportDto.setUserId(userId);
        ReportDto res = reportService.addReport(reportDto);
        return ResponseEntity.created(null).body(new ResponseDto("Add report successfully", res, HttpStatus.CREATED.value()));
    }

    @PutMapping("/{id}/wallets/money")
    public ResponseEntity<?> updateMoneyForUser(@PathVariable("id") String userId, @RequestBody WalletDto walletDto) {
        walletDto.setUserId(userId);
        WalletDto res = walletService.updateMoneyForUser(walletDto);
        if (res == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Update money failed", null, HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.ok(new ResponseDto("Update money successfully", res, HttpStatus.OK.value()));
    }

    @GetMapping("/{id}/reward-points")
    public ResponseEntity<?> getRewardPoint(@PathVariable("id") String userId) {
        RewardPointDto rewardPointDto = rewardPointService.getRewardPoint(userId);
        if (rewardPointDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Reward point not found", null, HttpStatus.NOT_FOUND.value()));
        }
        return ResponseEntity.ok(new ResponseDto("Get reward point successfully", rewardPointDto, HttpStatus.OK.value()));
    }

    @PutMapping("/{id}/reward-points/add")
    public ResponseEntity<?> updateRewardPoint(@PathVariable("id") String userId, @RequestBody Double rewardPointAmount) {
        RewardPointDto res = rewardPointService.addRewardPoint(userId, rewardPointAmount);
        if (res == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Update reward point failed", null, HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.ok(new ResponseDto("Update reward point successfully", res, HttpStatus.OK.value()));
    }

    @PutMapping("/{id}/reward-points/deduct")
    public ResponseEntity<?> subtractRewardPoint(@PathVariable("id") String userId, @RequestBody Double rewardPointAmount) {
        RewardPointDto res = rewardPointService.deductRewardPoint(userId, rewardPointAmount);
        if (res == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Update reward point failed", null, HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.ok(new ResponseDto("Update reward point successfully", res, HttpStatus.OK.value()));
    }

}
