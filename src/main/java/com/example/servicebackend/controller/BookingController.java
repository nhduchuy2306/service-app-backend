package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.BookingDto;
import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<?> addBooking(@RequestBody BookingDto bookingDto) {
        BookingDto newBooking = bookingService.addBooking(bookingDto);
        return ResponseEntity.created(null).body(new ResponseDto("Create Booking Successfully", newBooking, HttpStatus.CREATED.value()));
    }
}
