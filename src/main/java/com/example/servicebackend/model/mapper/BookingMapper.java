package com.example.servicebackend.model.mapper;

import com.example.servicebackend.model.dto.BookingDto;
import com.example.servicebackend.model.entity.Booking;
import com.example.servicebackend.model.entity.Partner;
import com.example.servicebackend.model.entity.ServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(target = "serviceRequestId", source = "booking.serviceRequest.requestId")
    @Mapping(target = "partnerId", source = "booking.partner.partnerId")
    BookingDto toDto(Booking booking);

    @Mapping(target = "serviceRequest", source = "serviceRequestId", qualifiedByName = "mapServiceRequestIdToServiceRequest")
    @Mapping(target = "partner", source = "partnerId", qualifiedByName = "mapPartnerIdToPartner")
    @Mapping(target = "paymentTransaction", ignore = true)
    @Mapping(target = "reports", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    Booking toEntity(BookingDto bookingDto);

    @Named("mapServiceRequestIdToServiceRequest")
    default ServiceRequest mapServiceRequestIdToServiceRequest(Long serviceRequestId) {
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setRequestId(serviceRequestId);
        return serviceRequest;
    }

    @Named("mapPartnerIdToPartner")
    default Partner mapPartnerIdToPartner(String partnerId) {
        Partner partner = new Partner();
        partner.setPartnerId(partnerId);
        return partner;
    }

}
