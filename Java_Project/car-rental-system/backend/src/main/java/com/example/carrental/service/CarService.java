package com.example.carrental.service;

import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    public List<Car> listAll() { return repo.findAll(); }
    public List<Car> listAvailable() { return repo.findByAvailableTrue(); }
    public Optional<Car> get(Long id) { return repo.findById(id); }
    public Car save(Car car) { return repo.save(car); }
}
