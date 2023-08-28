package com.example.servicebackend.model.dto;

import com.example.servicebackend.model.enumtype.ComboEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComboDto {
    private Long comboId;
    private String comboName;
    private String comboDescription;
    private String comboPrice;
    private ComboEnum comboType;
    private Date startDate;
    private Date endDate;
}
