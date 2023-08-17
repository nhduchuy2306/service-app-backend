package com.example.servicebackend.compositekey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboAssociationId implements Serializable {
    private Long comboId;
    private Long requestId;
}
