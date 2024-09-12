package com.bit.cscms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int product_id;
    private String product_name;
    private int product_price;
    private String product_description;
    private String product_image;
    private int cat_id;
    private int brand_id;
    private int make_id;


}
