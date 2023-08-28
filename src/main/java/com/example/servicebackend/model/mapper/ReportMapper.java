package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.ReportDto;
import com.example.servicebackend.model.entity.Booking;
import com.example.servicebackend.model.entity.Report;
import com.example.servicebackend.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "bookingId", source = "booking.bookingId")
    ReportDto toDto(Report report);

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    @Mapping(target = "booking", source = "bookingId", qualifiedByName = "mapBookingIdToBooking")
    Report toEntity(ReportDto reportDto);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        return user;
    }

    @Named("mapBookingIdToBooking")
    default Booking mapBookingIdToBooking(Long bookingId) {
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        return booking;
    }

}
