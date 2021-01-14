package com.javatechnologies.springdemo.controller;

import com.javatechnologies.springdemo.entity.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import com.javatechnologies.springdemo.service.MotorcycleService;

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

    @GetMapping(value = "/getAllMotorcycles")
    public List<Motorcycle> GetAllMotorcycles() {
        return motorcycleService.GetAllMotorcycles();
    }

    @GetMapping(value = "/getMotorcycleById/{id}")
    public Optional<Motorcycle> GetMotorcycleById(@PathVariable int id) {
        return motorcycleService.GetById(id);
    }

    @PostMapping(value = "/motorcycle/addNewMotorcycle")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorcycle AddNewMotorcycle(@RequestBody Motorcycle motorcycle) {
        return motorcycleService.AddNewMotorcycle(motorcycle);
    }

    @DeleteMapping(value = "/motorcycle/deleteById/{id}")
    public String DeleteById(@PathVariable int id) {
        return motorcycleService.deleteById(id);
    }
}
