package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.model.dto.UserDiscountDto;
import com.example.servicebackend.service.UserDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-discounts")
@RequiredArgsConstructor
public class UserDiscountController {

    private final UserDiscountService userDiscountService;

    @PostMapping("")
    public ResponseEntity<?> addUserDiscount(@RequestBody UserDiscountDto userDiscountDto) {
        UserDiscountDto newUserDiscountDto = userDiscountService.addUserDiscount(userDiscountDto);
        if (newUserDiscountDto != null)
            return ResponseEntity.ok(new ResponseDto("User discount added successfully", newUserDiscountDto, HttpStatus.OK.value()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("User discount not added", null, HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @DeleteMapping("/{userDiscountId}")
    public ResponseEntity<?> disableUserDiscount(@PathVariable Long userDiscountId) {
        UserDiscountDto userDiscountDto = userDiscountService.disableUserDiscount(userDiscountId);
        if (userDiscountDto != null)
            return ResponseEntity.ok(new ResponseDto("User discount disabled successfully", userDiscountDto, HttpStatus.OK.value()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("User discount not disabled", null, HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
