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

    @Mapping(target = "serviceRequest", source = "booking.serviceRequest.serviceRequestId")
    @Mapping(target = "partner", source = "booking.partner.partnerId")
    BookingDto toDto(Booking booking);

    @Mapping(target = "serviceRequest", source = "serviceRequestId", qualifiedByName = "serviceRequestIdToServiceRequest")
    @Mapping(target = "partner", source = "partnerId", qualifiedByName = "partnerIdToPartner")
    Booking toEntity(BookingDto bookingDto);

    @Named("serviceRequestIdToServiceRequest")
    default ServiceRequest serviceRequestIdToServiceRequest(Long serviceRequestId) {
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setRequestId(serviceRequestId);
        return serviceRequest;
    }

    @Named("partnerIdToPartner")
    default Partner partnerIdToPartner(String partnerId) {
        Partner partner = new Partner();
        partner.setPartnerId(partnerId);
        return partner;
    }
}
