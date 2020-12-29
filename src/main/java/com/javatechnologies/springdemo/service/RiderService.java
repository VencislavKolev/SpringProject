package com.javatechnologies.springdemo.service;


import com.javatechnologies.springdemo.entity.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {

    @Autowired
    RiderRepo riderRepo;

    public Rider AddNewRider(Rider rider) {
        riderRepo.save(rider);
        return rider;
    }

    public List<Rider> GetAllRiders() {
        return riderRepo.findAll();
    }

    public Rider GetByRaceNumber(int racenumber) {
        for (Rider obj : riderRepo.findAll()) {
            if (obj.getRacenumber() == racenumber) {
                return obj;
            }
        }
        return null;
    }

    public String getEmailById(int id) {
        for (Rider obj : riderRepo.findAll()) {
            if (obj.getId() == id) {
                return "The email address for rider with ID %d is: ".formatted(id) + obj.getEmail();
            }
        }
        return "Rider with ID %d was not found in our records.".formatted(id);
    }

    public String deleteByRaceNumber(int racenumber) {
        for (Rider obj : riderRepo.findAll()) {
            if (obj.getRacenumber() == racenumber) {
                riderRepo.delete(obj);
                return "Rider with race number %d was successfully deleted!".formatted(racenumber);
            }
        }
        return "Rider with race number %d was not found in our records".formatted(racenumber);
    }
}
