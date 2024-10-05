package com.bit.cscms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
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
