package com.javatechnologies.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.javatechnologies.springdemo.entity.Rider;
import com.javatechnologies.springdemo.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class RiderController {

    @Autowired
    RiderService riderService;

    @GetMapping(value = "/getAllRiders")
    public List<Rider> GetAllMotorcycles() {
        return riderService.GetAllRiders();
    }

    @GetMapping(value = "/getByRaceNumber/{racenumber}")
    public Rider GetByRaceNumber(@PathVariable int racenumber) {
        return riderService.GetByRaceNumber(racenumber);
    }

    @GetMapping(value = "/getEmailById/{id}")
    public String GetEmailById(@PathVariable int id) {
        return riderService.GetEmailById(id);
    }

    @PostMapping(value = "/rider/addNewRider")
    @ResponseStatus(HttpStatus.CREATED)
    public Rider AddNewRider(@RequestBody Rider rider) {
        return riderService.AddNewRider(rider);
    }

    @DeleteMapping(value = "/rider/deleteByRaceNumber/{racenumber}")
    public String DeleteByRaceNumber(@PathVariable int racenumber) {
        return riderService.DeleteByRaceNumber(racenumber);
    }
}
