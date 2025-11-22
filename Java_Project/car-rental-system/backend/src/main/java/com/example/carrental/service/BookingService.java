package com.example.carrental.service;

import com.example.carrental.model.Booking;
import com.example.carrental.model.Car;
import com.example.carrental.repository.BookingRepository;
import com.example.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepo;
    private final CarRepository carRepo;

    public BookingService(BookingRepository bookingRepo, CarRepository carRepo) {
        this.bookingRepo = bookingRepo;
        this.carRepo = carRepo;
    }

    public Booking createBooking(Booking booking) {
        Optional<Car> c = carRepo.findById(booking.getCarId());
        if (c.isEmpty() || !c.get().getAvailable()) {
            throw new IllegalArgumentException("Car not available");
        }
        long days = ChronoUnit.DAYS.between(booking.getFromDate(), booking.getToDate()) + 1;
        double total = days * c.get().getPricePerDay();
        booking.setTotalPrice(total);
        Booking saved = bookingRepo.save(booking);
        Car car = c.get();
        car.setAvailable(false);
        carRepo.save(car);
        return saved;
    }
}
