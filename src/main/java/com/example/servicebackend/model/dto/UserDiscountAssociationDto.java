package com.example.servicebackend.model.dto;

import com.example.servicebackend.model.enumtype.UserDiscountAssociationEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDiscountAssociationDto {
    private Long requestId;
    private Long userDiscountId;
    private UserDiscountAssociationEnum status;
}
