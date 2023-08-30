package com.example.servicebackend.model.dto;

import com.example.servicebackend.model.enumtype.DiscountExchangeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiscountExchangeDto {
    private Long discountExchangeId;
    private Double discount;
    private String description;
    private DiscountExchangeEnum status;
    private Date startDate;
    private Date endDate;
}
