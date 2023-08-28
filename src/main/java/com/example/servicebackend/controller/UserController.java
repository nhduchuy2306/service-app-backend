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

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String userId) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto != null) {
            return ResponseEntity.ok(new ResponseDto("Get user successfully", userDto, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("User not found", null, HttpStatus.NOT_FOUND.value()));
    }

    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        UserDto res = userService.addUser(userDto);
        return ResponseEntity.created(null).body(new ResponseDto("Add user successfully", res, HttpStatus.CREATED.value()));
    }

    @PostMapping("/auth/google")
    public ResponseEntity<?> addGoogleUserInfor(@RequestBody GoogleUserInfoDto googleUserInfoDto) {
        UserDto userDto = userService.getUserById(googleUserInfoDto.getUid());
        if (userDto != null) {
            // User already exists
            return ResponseEntity.ok(new ResponseDto("User already exists", userDto, HttpStatus.OK.value()));
        } else {
            // User not exists
            UserDto res = userService.addGoogleUserInfor(googleUserInfoDto);
            if(res == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Add user failed", null, HttpStatus.BAD_REQUEST.value()));
            }
            // Create wallet
            WalletDto walletDto = new WalletDto();
            walletDto.setUserId(res.getUserId());
            walletDto.setMoney(0.0);
            walletDto.setStatus("ACTIVE");
            walletDto.setPartnerId(null);
            walletService.addWalletToUser(walletDto);

            return ResponseEntity.created(null).body(new ResponseDto("Add user successfully", res, HttpStatus.CREATED.value()));
        }
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
        if(res == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Update money failed", null, HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.ok(new ResponseDto("Update money successfully", res, HttpStatus.OK.value()));
    }

}
