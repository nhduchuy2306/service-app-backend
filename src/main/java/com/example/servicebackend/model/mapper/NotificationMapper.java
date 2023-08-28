package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.NotificationDto;
import com.example.servicebackend.model.entity.Booking;
import com.example.servicebackend.model.entity.Notification;
import com.example.servicebackend.model.entity.PaymentTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(target = "bookingId", source = "booking.bookingId")
    @Mapping(target = "paymentTransactionId", source = "paymentTransaction.paymentTransactionId")
    NotificationDto toNotificationDto(Notification notification);

    @Mapping(target = "booking", source = "bookingId", qualifiedByName = "mapBookingIdToBooking")
    @Mapping(target = "paymentTransaction", source = "paymentTransactionId", qualifiedByName = "mapPaymentTransactionIdToPaymentTransaction")
    Notification toNotification(NotificationDto notificationDto);

    @Named("mapBookingIdToBooking")
    default Booking mapBookingIdToBooking(Long bookingId) {
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        return booking;
    }

    @Named("mapPaymentTransactionIdToPaymentTransaction")
    default PaymentTransaction mapPaymentTransactionIdToPaymentTransaction(Long paymentTransactionId) {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPaymentTransactionId(paymentTransactionId);
        return paymentTransaction;
    }

}
