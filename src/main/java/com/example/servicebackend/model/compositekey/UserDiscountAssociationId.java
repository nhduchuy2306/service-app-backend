package com.example.servicebackend.model.compositekey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDiscountAssociationId implements Serializable {
    private Long requestId;
    private Long userDiscountId;
}
