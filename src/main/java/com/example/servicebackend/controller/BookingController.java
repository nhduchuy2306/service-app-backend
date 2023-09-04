package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.BookingDto;
import com.example.servicebackend.service.BookingService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
@Tag(name = "Booking API")
@SecurityRequirement(name = "Authorization")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<?> addBooking(@RequestBody BookingDto bookingDto) {
        BookingDto newBooking = bookingService.addBooking(bookingDto);
        return ResponseEntity.created(null).body(newBooking);
    }
}
