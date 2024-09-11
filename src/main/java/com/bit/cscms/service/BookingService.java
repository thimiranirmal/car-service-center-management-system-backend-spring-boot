package com.bit.cscms.service;

import com.bit.cscms.dto.BookingDTO;
import com.bit.cscms.model.Booking;
import com.bit.cscms.repo.BookingRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper modelMapper;

    public BookingDTO makeBooking(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        bookingRepo.save(booking);
        return modelMapper.map(bookingDTO, BookingDTO.class);
    }

    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();
        return modelMapper.map(bookings, new TypeToken<List<BookingDTO>>() {}.getType());
    }

    public BookingDTO getBookingById(int id) {
        Booking booking = bookingRepo.findById(id).get();
        return modelMapper.map(booking, BookingDTO.class);
    }

    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        bookingRepo.save(booking);
        return modelMapper.map(bookingDTO, BookingDTO.class);
    }
}
