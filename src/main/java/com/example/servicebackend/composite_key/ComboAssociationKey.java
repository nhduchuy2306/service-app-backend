package com.example.servicebackend.composite_key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComboAssociationKey implements Serializable {
    private Long comboId;
    private Long requestId;
}
