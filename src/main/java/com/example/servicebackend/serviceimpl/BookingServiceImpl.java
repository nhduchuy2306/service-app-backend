package com.example.servicebackend.serviceimpl;

import com.example.servicebackend.model.dto.BookingDto;
import com.example.servicebackend.model.entity.Booking;
import com.example.servicebackend.model.enumtype.BookingEnum;
import com.example.servicebackend.model.mapper.BookingMapper;
import com.example.servicebackend.repository.BookingRepository;
import com.example.servicebackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<BookingDto> findAllBookingByPartnerId(String partnerId) {
        List<Booking> bookings = bookingRepository.findAllBookingByPartnerId(partnerId, BookingEnum.PENDING);
        if (bookings != null) {
            return bookings.stream().map(BookingMapper.INSTANCE::toDto).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<BookingDto> findAllBookingByUserId(String userId) {
        List<Booking> bookings = bookingRepository.findAllBookingByUserId(userId, BookingEnum.PENDING);
        if (bookings != null) {
            return bookings.stream().map(BookingMapper.INSTANCE::toDto).collect(Collectors.toList());
        }
        return null;
    }
}
