package com.example.servicebackend.composite_key;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerWorkingTypeId implements Serializable {
    private String partnerId;
    private Long serviceId;
}
