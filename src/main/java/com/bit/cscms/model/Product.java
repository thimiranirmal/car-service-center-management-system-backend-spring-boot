package com.bit.cscms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private int product_id;
    private String product_name;
    private String product_description;
    private int product_price;
    private int product_image;
    private int cat_id;
    private int brand_id;
    private int make_id;
}
