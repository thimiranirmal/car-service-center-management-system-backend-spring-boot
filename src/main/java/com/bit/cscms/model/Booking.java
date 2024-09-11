package com.bit.cscms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int customerId;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleNo;
    private String vehicleManufacturedYear;
    private Date bookingDate;
    private Timestamp bookingTime;
    private String bookingStatus;
    private String message;

}
