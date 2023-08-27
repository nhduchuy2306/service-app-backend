package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.BookingDto;
import com.example.servicebackend.model.entity.Booking;
import com.example.servicebackend.model.enumtype.BookingEnum;
import com.example.servicebackend.model.mapper.BookingMapper;
import com.example.servicebackend.repository.BookingRepository;
import com.example.servicebackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public BookingDto addBooking(BookingDto bookingDto) {
        Booking booking = BookingMapper.INSTANCE.toEntity(bookingDto);
        Booking newBooking = bookingRepository.save(booking);
        if (newBooking != null) {
            return BookingMapper.INSTANCE.toDto(newBooking);
        }
        return null;
    }

    @Override
    public BookingDto findAllBookingByPartnerId(String partnerId) {
        Booking booking = bookingRepository.findAllBookingByPartnerId(partnerId, BookingEnum.PENDING);
        if (booking != null) {
            return BookingMapper.INSTANCE.toDto(booking);
        }
        return null;
    }

    @Override
    public BookingDto findAllBookingByUserId(String userId) {
        Booking booking = bookingRepository.findAllBookingByUserId(userId, BookingEnum.PENDING);
        if (booking != null) {
            return BookingMapper.INSTANCE.toDto(booking);
        }
        return null;
    }
}
