package com.bit.cscms.model;

import jakarta.persistence.*;
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
    private String bookingDate;
    private String bookingTime;
    private String bookingStatus;
    private String message;



}
