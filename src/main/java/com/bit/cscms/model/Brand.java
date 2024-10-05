package com.bit.cscms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brand_id;
    private String brand_name;
    private String brand_description;
    @Lob
    @Column(length = 1000000000)
    private byte[] brand_img;
}
