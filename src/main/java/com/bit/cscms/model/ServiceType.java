package com.bit.cscms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType {
    @Id
    private int serviceTypeId;
    private String serviceTypeName;
    private int servicePrice;
}
