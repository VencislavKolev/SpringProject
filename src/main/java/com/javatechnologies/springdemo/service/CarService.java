package com.javatechnologies.springdemo.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.javatechnologies.springdemo.dto.PriceDto;
import com.javatechnologies.springdemo.entity.Car;
import com.javatechnologies.springdemo.entity.Owner;


@Service
public class CarService {

    @Autowired
    CarRepo carRepo;
    @Autowired
    OwnerRepo ownerRepo;

    public void addNewCar(Car car) {
        carRepo.save(car);
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }


    public Optional<Car> getById(int id) {
        return carRepo.findById(id);
    }

    public void addNewOwner(Owner owner) {
        ownerRepo.save(owner);
    }


//    public List<Car> getAllCars() {
//
//        return cars;
//    }
//
//
//    public void editPrice(PriceDto ob) {
//        for (Car car : cars) {
//            if (car.getId() == ob.getId()) {
//                car.setPrice(ob.getNewPrice());
//
//
//            }
//
//        }
//
//    }
//
//    public Car getCarById(int id) {
//
//        for (Car ob : cars) {
//            if (ob.getId() == id) {
//
//                return ob;
//            }
//        }
//        return null;
//    }
//
//    public void deleteById(int id) {
//
//        for (Car ob : cars) {
//            if (ob.getId() == id) {
//                cars.remove(id);
//            }
//        }
//    }
}

