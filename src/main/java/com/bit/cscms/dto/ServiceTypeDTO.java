package com.bit.cscms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTypeDTO {
    private int serviceTypeId;
    private String serviceTypeName;
    private int servicePrice;
}
