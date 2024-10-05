package com.bit.cscms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cat_id;
    private String cat_name;
    private String cat_desc;
    @Lob
    @Column(length = 1000000000)
    private byte[] cat_img;
}
