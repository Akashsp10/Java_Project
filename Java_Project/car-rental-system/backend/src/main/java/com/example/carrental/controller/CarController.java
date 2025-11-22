package com.example.carrental.controller;

import com.example.carrental.model.Car;
import com.example.carrental.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "*")
public class CarController {
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> all() { return service.listAll(); }

    @GetMapping("/available")
    public List<Car> available() { return service.listAvailable(); }

    @PostMapping
    public Car create(@RequestBody Car car) { return service.save(car); }

    @GetMapping("/{id}")
    public ResponseEntity<Car> get(@PathVariable Long id) {
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
