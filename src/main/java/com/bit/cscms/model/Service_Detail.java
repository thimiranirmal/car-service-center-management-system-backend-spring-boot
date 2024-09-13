package com.bit.cscms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_detail_id;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @ManyToOne
    @JoinColumn(name = "serviceType_id")
    private ServiceType serviceType;
}
