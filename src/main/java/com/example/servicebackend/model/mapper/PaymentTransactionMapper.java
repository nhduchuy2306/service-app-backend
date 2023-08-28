package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.PaymentTransactionDto;
import com.example.servicebackend.model.entity.Booking;
import com.example.servicebackend.model.entity.PaymentMethod;
import com.example.servicebackend.model.entity.PaymentTransaction;
import com.example.servicebackend.model.entity.UserDiscount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentTransactionMapper {

    PaymentTransactionMapper INSTANCE = Mappers.getMapper(PaymentTransactionMapper.class);

    @Mapping(target = "paymentMethodId", source = "paymentMethod.paymentMethodId")
    @Mapping(target = "userDiscountId", source = "userDiscount.userDiscountId")
    @Mapping(target = "bookingId", source = "booking.bookingId")
    PaymentTransactionDto toDto(PaymentTransaction paymentTransaction);

    @Mapping(target = "paymentMethod", source = "paymentMethodId", qualifiedByName = "mapPaymentMethodIdToPaymentMethod")
    @Mapping(target = "userDiscount", source = "userDiscountId", qualifiedByName = "mapUserDiscountIdToUserDiscount")
    @Mapping(target = "booking", source = "bookingId", qualifiedByName = "mapBookingIdToBooking")
    PaymentTransaction toEntity(PaymentTransactionDto paymentTransactionDto);

    @Named("mapPaymentMethodIdToPaymentMethod")
    default PaymentMethod mapPaymentMethodIdToPaymentMethod(Long paymentMethodId) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentMethodId(paymentMethodId);
        return paymentMethod;
    }

    @Named("mapUserDiscountIdToUserDiscount")
    default UserDiscount mapUserDiscountIdToUserDiscount(Long userDiscountId) {
        UserDiscount userDiscount = new UserDiscount();
        userDiscount.setUserDiscountId(userDiscountId);
        return userDiscount;
    }

    @Named("mapBookingIdToBooking")
    default Booking mapBookingIdToBooking(Long bookingId) {
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        return booking;
    }
}