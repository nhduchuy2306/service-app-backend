package com.example.servicebackend.service;

import com.example.servicebackend.model.dto.BookingDto;

import java.util.List;

public interface BookingService {
    BookingDto addBooking(BookingDto bookingDto);

    List<BookingDto> findAllBookingByPartnerId(String partnerId);

    List<BookingDto> findAllBookingByUserId(String userId);
}
