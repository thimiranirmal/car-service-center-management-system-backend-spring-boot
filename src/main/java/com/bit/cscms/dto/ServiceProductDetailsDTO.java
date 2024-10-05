package com.bit.cscms.dto;

import com.bit.cscms.model.ProductDetailsQty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProductDetailsDTO {

    private int serviceProductDetailId;
    private int serviceId;
    private List<ProductDetailsQty> productIdWithQty;
}
