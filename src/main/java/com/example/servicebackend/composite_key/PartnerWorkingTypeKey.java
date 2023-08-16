package com.example.servicebackend.composite_key;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartnerWorkingTypeKey implements Serializable {
    private Long partnerId;
    private Long serviceId;
}
