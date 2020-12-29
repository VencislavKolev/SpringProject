package com.javatechnologies.springdemo.service;

import com.javatechnologies.springdemo.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepo teamRepo;

    public Team AddNewTeam(Team team) {
        teamRepo.save(team);
        return team;
    }

    public List<Team> GetAllTeams() {
        return teamRepo.findAll();
    }

    public Team GetTeamWithMostPoints() {
        return Collections.max(teamRepo.findAll(), Comparator.comparing(Team::getTotalPoints));
    }

    public Team GetTeamWithLeastPoints() {
        return Collections.min(teamRepo.findAll(), Comparator.comparing(Team::getTotalPoints));
    }

    public String deleteById(int id) {
        for (Team obj : teamRepo.findAll()) {
            if (obj.getId() == id) {
                teamRepo.delete(obj);
                return "Team with ID %d was successfully deleted!".formatted(id);
            }
        }
        return "Team with ID %d was not found in our records".formatted(id);
    }
}
