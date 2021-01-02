package com.javatechnologies.springdemo.controller;

import com.javatechnologies.springdemo.entity.Rider;
import com.javatechnologies.springdemo.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RiderController {

    @Autowired
    RiderService riderService;

    @PostMapping(value = "/addNewRider")
    @ResponseStatus(HttpStatus.CREATED)
    public Rider AddNewRider(@RequestBody Rider rider) {
        return riderService.AddNewRider(rider);
    }

    @GetMapping(value = "/getAllRiders")
    public List<Rider> getAllMotorcycles() {
        return riderService.GetAllRiders();
    }

    @GetMapping(value = "/getByRaceNumber/{racenumber}")
    public Rider getByRaceNumber(@PathVariable int racenumber) {
        return riderService.GetByRaceNumber(racenumber);
    }

    @GetMapping(value = "/getEmailById/{id}")
    public String getEmailById(@PathVariable int id) {
        return riderService.getEmailById(id);
    }

    @DeleteMapping(value = "/deleteByRaceNumber/{racenumber}")
    public String deleteByRaceNumber(@PathVariable int racenumber) {
        return riderService.deleteByRaceNumber(racenumber);
    }
}
