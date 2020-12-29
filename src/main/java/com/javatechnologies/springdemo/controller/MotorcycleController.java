package com.javatechnologies.springdemo.controller;

import com.javatechnologies.springdemo.entity.Motorcycle;
import com.javatechnologies.springdemo.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MotorcycleController {

    @Autowired
    MotorcycleService motorcycleService;

    @GetMapping(value = "/test")
    public String testController() {
        return "MotorcycleController Test Passed";
    }

    @PostMapping(value = "/addNewMotorcycle")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorcycle addNewMotorcycle(@RequestBody Motorcycle motorcycle) {
        return motorcycleService.AddNewMotorcycle(motorcycle);
    }

    @GetMapping(value = "/getAllMotorcycles")
    public List<Motorcycle> getAllMotorcycles() {
        return motorcycleService.GetAllMotorcycles();
    }

    @GetMapping(value = "/getMotorcycleById/{id}")
    public Optional<Motorcycle> getMotorcycleById(@PathVariable int id) {
        return motorcycleService.GetById(id);
    }

    @DeleteMapping(value = "/motorcycle/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        return motorcycleService.deleteById(id);
    }
}
