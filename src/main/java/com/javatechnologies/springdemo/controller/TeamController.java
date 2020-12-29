package com.javatechnologies.springdemo.controller;

import com.javatechnologies.springdemo.entity.Team;
import com.javatechnologies.springdemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping(value = "/addNewTeam")
    @ResponseStatus(HttpStatus.CREATED)
    public Team AddNewTeam(@RequestBody Team team) {
        return teamService.AddNewTeam(team);
    }

    @GetMapping(value = "/getAllTeams")
    public List<Team> getAllTeams() {
        return teamService.GetAllTeams();
    }

    @GetMapping(value = "/getTeamWithMostPoints")
    public Team getTeamWithMostPoints() {
        return teamService.GetTeamWithMostPoints();
    }

    @DeleteMapping(value = "/teams/deleteTeamWithLeastPoints")
    public Team deleteTeamWithLeastPoints() {
        return teamService.GetTeamWithLeastPoints();
    }

    @DeleteMapping(value = "/teams/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        return teamService.deleteById(id);
    }
}
