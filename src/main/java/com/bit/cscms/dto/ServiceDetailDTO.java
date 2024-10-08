package com.bit.cscms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDetailDTO {
    private int serviceDetailId;
    private int serviceId;
    private List<Integer> serviceTypeIds;
}
