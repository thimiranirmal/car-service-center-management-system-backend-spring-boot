package com.bit.cscms.repo;

import com.bit.cscms.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
}
