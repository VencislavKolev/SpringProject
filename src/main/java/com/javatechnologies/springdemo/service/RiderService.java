package com.javatechnologies.springdemo.service;

import org.springframework.stereotype.Service;
import com.javatechnologies.springdemo.entity.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import com.javatechnologies.springdemo.Exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class RiderService {

    @Autowired
    RiderRepo riderRepo;

    public Rider AddNewRider(Rider rider) {

        int riderAge = rider.getAge();
        if (riderAge < 5 || riderAge > 60) {
            throw new IllegalArgumentException("Age should be between 5 and 60!");
        }
        int racenumber = rider.getRacenumber();

        if (racenumber <= 0 || racenumber > 999) {
            throw new IllegalArgumentException("Race number cannot be less than 0 or bigger than 999!");
        } else if (riderRepo.existsByRacenumber(racenumber)) {
            throw new IllegalArgumentException(String.format("Rider with race number %d already exists", racenumber));
        }

        riderRepo.save(rider);
        return rider;
    }

    public List<Rider> GetAllRiders() {
        return riderRepo.findAll();
    }

    public Rider GetByRaceNumber(int racenumber) {

        if (!riderRepo.existsByRacenumber(racenumber)) {
            throw new ResourceNotFoundException(String.format("Rider with race number %d does not exist in our records!", racenumber));
        }
        Rider rider = null;
        for (Rider obj : riderRepo.findAll()) {
            if (obj.getRacenumber() == racenumber) {
                rider = obj;
            }
        }
        return rider;
    }


    public String GetEmailById(int id) {
        for (Rider obj : riderRepo.findAll()) {
            if (obj.getId() == id) {
                return "The email address for rider with ID %d is: ".formatted(id) + obj.getEmail();
            }
        }
        return "Rider with ID %d was not found in our records.".formatted(id);
    }

    public String DeleteByRaceNumber(int racenumber) {
        if (racenumber > 0 && racenumber <= 999) {
            for (Rider obj : riderRepo.findAll()) {
                if (obj.getRacenumber() == racenumber) {
                    riderRepo.delete(obj);
                    return "Rider with race number %d was successfully deleted!".formatted(racenumber);
                }
            }
        }
        return "Rider with race number %d was not found in our records".formatted(racenumber);
    }

    public String DeleteByTeamId(int teamId) {
        for (Rider obj : riderRepo.findAll()) {
            if (obj.getTeamId() == teamId) {
                riderRepo.delete(obj);
                return "Rider with teamId %d was successfully deleted!".formatted(teamId);
            }
        }
        return "Rider with teamId %d was not found in our records".formatted(teamId);
    }
}
