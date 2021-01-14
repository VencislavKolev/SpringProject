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

    @GetMapping(value = "/getAllTeams")
    public List<Team> GetAllTeams() {
        return teamService.GetAllTeams();
    }

    @GetMapping(value = "/getTeamWithMostPoints")
    public Team GetTeamWithMostPoints() {
        return teamService.GetTeamWithMostPoints();
    }

    @PostMapping(value = "team/addNewTeam")
    @ResponseStatus(HttpStatus.CREATED)
    public void AddNewTeam(@RequestBody Team team) {
        teamService.AddNewTeam(team);
    }

    @PostMapping(value = "team/addRiderToTeam")
    public String AddRiderToTeam(String teamName, String riderName) {
        return teamService.AddRiderToTeam(teamName, riderName);
    }

    @DeleteMapping(value = "/team/deleteTeamWithLeastPoints")
    public void DeleteTeamWithLeastPoints() {
        teamService.DeleteTeamWithLeastPoints();
    }

    @DeleteMapping(value = "/team/deleteById/{id}")
    public String DeleteById(@PathVariable int id) {
        teamService.DeleteById(id);
        return "Team with ID %d was successfully deleted!".formatted(id);
    }
}
