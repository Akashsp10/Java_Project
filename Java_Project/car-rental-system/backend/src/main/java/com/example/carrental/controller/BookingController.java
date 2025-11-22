package com.example.carrental.controller;

import com.example.carrental.model.Booking;
import com.example.carrental.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {
    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }
    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return service.createBooking(booking);
    }
}
