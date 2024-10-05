package com.bit.cscms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;
    private String service_status;
    private String assign_date;
    private String comment;
    private int emp_id;
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
