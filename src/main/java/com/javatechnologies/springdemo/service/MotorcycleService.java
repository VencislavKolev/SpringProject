package com.javatechnologies.springdemo.service;

//import com.javatechnologies.springdemo.entity.Rider;

import com.javatechnologies.springdemo.entity.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MotorcycleService {
    @Autowired
    MotorcycleRepo motorcycleRepo;

/*    @Autowired
    RiderRepo riderRepo;*/

    public Motorcycle AddNewMotorcycle(Motorcycle motorcycle) {
        motorcycleRepo.save(motorcycle);
        return motorcycle;
    }

    public List<Motorcycle> GetAllMotorcycles() {
        return motorcycleRepo.findAll();
    }

    public Optional<Motorcycle> GetById(int id) {
        return motorcycleRepo.findById(id);
    }

    public String deleteById(int id) {
        for (Motorcycle obj : motorcycleRepo.findAll()) {
            if (obj.getId() == id) {
                motorcycleRepo.delete(obj);
                return "Item with ID %d was successfully deleted!".formatted(id);
            }
        }
        return "Item with ID %d was not found in our records".formatted(id);
    }
}
