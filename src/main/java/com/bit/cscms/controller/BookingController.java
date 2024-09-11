package com.bit.cscms.controller;

import com.bit.cscms.dto.BookingDTO;
import com.bit.cscms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public BookingDTO makeBooking(BookingDTO bookingDTO) {
        return bookingService.makeBooking(bookingDTO);
    }

    @GetMapping("/getallbookings")
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/getbooking/{book_id}")
    public BookingDTO getBooking(@PathVariable int book_id) {
        return bookingService.getBookingById(book_id);
    }

    @PutMapping("/updatebooking")
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.updateBooking(bookingDTO);
    }
}
