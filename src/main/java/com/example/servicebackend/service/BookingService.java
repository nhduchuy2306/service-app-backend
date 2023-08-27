package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.BookingDto;

public interface BookingService {
    BookingDto addBooking(BookingDto bookingDto);
    BookingDto findAllBookingByPartnerId(String partnerId);
    BookingDto findAllBookingByUserId(String userId);
}
