package com.bit.cscms.dto;

import com.bit.cscms.model.Booking;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {

    private int service_id;
    private String service_status;
    private Date assign_date;
    private String comment;
    private int emp_id;
    private int booking_id;
}
