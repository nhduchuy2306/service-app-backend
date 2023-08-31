package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.PaymentTransactionDto;
import com.example.servicebackend.model.entity.Booking;
import com.example.servicebackend.model.entity.PaymentMethod;
import com.example.servicebackend.model.entity.PaymentTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentTransactionMapper {

    PaymentTransactionMapper INSTANCE = Mappers.getMapper(PaymentTransactionMapper.class);

    @Mapping(target = "paymentMethodId", source = "paymentMethod.paymentMethodId")
    @Mapping(target = "bookingId", source = "booking.bookingId")
    PaymentTransactionDto toDto(PaymentTransaction paymentTransaction);

    @Mapping(target = "paymentMethod", source = "paymentMethodId", qualifiedByName = "mapPaymentMethodIdToPaymentMethod")
    @Mapping(target = "booking", source = "bookingId", qualifiedByName = "mapBookingIdToBooking")
    @Mapping(target = "notifications", ignore = true)
    PaymentTransaction toEntity(PaymentTransactionDto paymentTransactionDto);

    @Named("mapPaymentMethodIdToPaymentMethod")
    default PaymentMethod mapPaymentMethodIdToPaymentMethod(Long paymentMethodId) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentMethodId(paymentMethodId);
        return paymentMethod;
    }

    @Named("mapBookingIdToBooking")
    default Booking mapBookingIdToBooking(Long bookingId) {
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        return booking;
    }
}
