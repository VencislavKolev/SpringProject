package com.javatechnologies.springdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.javatechnologies.springdemo.dto.PriceDto;
import com.javatechnologies.springdemo.entity.Car;
import com.javatechnologies.springdemo.entity.Owner;
import com.javatechnologies.springdemo.service.CarService;

@RestController
public class CarController {


    @Autowired
    CarService carService;

    /*@GetMapping("/test")
    public String testController() {

        return "test";
    }*/

    @PostMapping("/addnewcar")
    public void addNewCar(@RequestBody Car car) {
        carService.addNewCar(car);
    }


    @GetMapping("/getallcars")
    public List<Car> getAllcars() {

        return carService.getAllCars();

    }

    @GetMapping("/getcarbyid/{id}")
    public Optional<Car> getCarById(@PathVariable int id) {

        return carService.getById(id);

    }

    @PostMapping("/addnewowner")
    public void addNewOwner(@RequestBody Owner owner) {

        carService.addNewOwner(owner);

    }
//	@DeleteMapping("/deletebyid/{id}")
//	 public void deleteById(@PathVariable   int  id) {
//		 carService.deleteById(id);
//	 }
}
