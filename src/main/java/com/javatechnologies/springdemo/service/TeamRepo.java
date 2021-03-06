package com.javatechnologies.springdemo.service;

import com.javatechnologies.springdemo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team,Integer> {

    boolean existsByMotorcycleBrandContains(String brand);
    Team getTeamByName(String teamName);
    //List<Team> findTeamByTotalPointsGreaterThan
}
