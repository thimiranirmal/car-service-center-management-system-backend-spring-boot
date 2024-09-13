package com.bit.cscms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceOrderId;
    @OneToOne
    @JoinColumn(name = "service_id")
    private Service service;
    private int amount;
    private String paymentMethod;
    private Date paymentDate;

}
