package com.example.servicebackend.repository;

import com.example.servicebackend.model.entity.Booking;
import com.example.servicebackend.model.enumtype.BookingEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.partner.partnerId = :partnerId AND b.status = :status ORDER BY b.bookingId DESC")
    Booking findAllBookingByPartnerId(String partnerId, BookingEnum status);

    @Query("SELECT b FROM Booking b WHERE b.serviceRequest.user.userId = :userId AND b.status = :status ORDER BY b.bookingId DESC")
    Booking findAllBookingByUserId(String userId, BookingEnum status);
}
