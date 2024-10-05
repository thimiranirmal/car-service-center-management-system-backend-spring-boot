package com.bit.cscms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceProductDetailId;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
}
