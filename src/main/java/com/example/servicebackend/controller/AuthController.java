package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.*;
import com.example.servicebackend.model.enumtype.PaymentMethodEnum;
import com.example.servicebackend.model.enumtype.PaymentMethodTypeEnum;
import com.example.servicebackend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PartnerService partnerService;
    private final WalletService walletService;
    private final RewardPointService rewardPointService;
    private final PaymentMethodService paymentMethodService;

    @PostMapping("/user/google-user-info")
    public ResponseEntity<?> addGoogleUserInfor(@RequestBody GoogleUserInfoDto googleUserInfoDto) {
        UserDto userDto = userService.getUserById(googleUserInfoDto.getUid());
        if (userDto != null) {
            // User already exists
            return ResponseEntity.ok(new ResponseDto("User already exists", userDto, HttpStatus.OK.value()));
        } else {
            // User not exists
            UserDto res = userService.addGoogleUserInfor(googleUserInfoDto);
            if (res == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("Add user failed", null, HttpStatus.BAD_REQUEST.value()));
            }
            // Create wallet
            WalletDto walletDto = new WalletDto();
            walletDto.setUserId(res.getUserId());
            walletDto.setMoney(0.0);
            walletDto.setStatus("ACTIVE");
            walletDto.setPartnerId(null);
            walletService.addWalletToUser(walletDto);

            // Create reward point
            rewardPointService.initRewardPoint(res.getUserId());

            // create payment method
            PaymentMethodDto paymentMethodDto = new PaymentMethodDto();
            paymentMethodDto.setUserId(res.getUserId());
            paymentMethodDto.setPaymentMethodType(PaymentMethodTypeEnum.PERSONAL_WALLET.getPaymentMethodType());
            paymentMethodDto.setStatus(PaymentMethodEnum.ACTIVE);
            paymentMethodDto.setPaymentMethodName("Personal Wallet");
            paymentMethodService.addPaymentMethod(paymentMethodDto);

            return ResponseEntity.created(null).body(new ResponseDto("Add user successfully", res, HttpStatus.CREATED.value()));
        }
    }

    @PostMapping("/partner/google-partner-info")
    public ResponseEntity<?> addGooglePartnerInfor(@RequestBody GoogleUserInfoDto googleUserInfoDto) {
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
}
