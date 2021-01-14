package com.javatechnologies.springdemo.service;

import org.springframework.stereotype.Service;
import com.javatechnologies.springdemo.entity.Team;
import com.javatechnologies.springdemo.entity.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import com.javatechnologies.springdemo.Exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Comparator;
import java.util.Collections;

@Service
public class TeamService {

    private final int _maxTeamCapacity = 2;
    @Autowired
    TeamRepo teamRepo;
    @Autowired
    RiderRepo riderRepo;
    @Autowired
    RiderService riderService;

    public void AddNewTeam(Team team) {

        String teamName = team.getName();

        if (teamName.length() < 3 || teamName.length() > 30) {
            throw new IllegalArgumentException("Team name should be between 3 and 30 symbols!");
        }
        else if (!teamName.contains(team.getMotorcycleBrand())) {
            throw new IllegalArgumentException("Motorcycle brand must be contained in the name of the team!");
        }
        else if (team.getTotalPoints() != 0) {
            throw new IllegalArgumentException("Initial points should be exactly zero!");
        }
        teamRepo.save(team);
    }

    public String AddRiderToTeam(String teamName, String riderName) {
        Team team = teamRepo.getTeamByName(teamName);
        Rider rider = riderRepo.getRiderByFullname(riderName);

        if (team == null) {
            throw new IllegalArgumentException(String.format("%s does not exist in team repository.", teamName));
        }
        if (rider == null) {
            throw new IllegalArgumentException(String.format("%s does not exist in rider repository.", riderName));
        }

        if (team.getRiders().size() + 1 > _maxTeamCapacity) {
            throw new IllegalArgumentException(String.format("%s has no free space for another rider.Try next season! ", teamName));
        } else if (rider.getTeamId() == 0) {
            rider.setTeamId(team.getId());
            team.getRiders().add(rider);
        }
        return String.format("%s was successfully added to %s!", rider.getFullname(), team.getName());

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

    public void DeleteTeamWithLeastPoints() {
        int teamId = this.GetTeamWithLeastPoints().getId();
        this.DeleteById(teamId);
    }

    public void DeleteById(int id) {
        if (!teamRepo.existsById(id)) {
            throw new ResourceNotFoundException(String.format("Team with id %d does not exist", id));
        }
        this.DeleteDataFromTeam(id);
    }

    private void DeleteDataFromTeam(int id) {
        for (Team obj : teamRepo.findAll()) {
            if (obj.getId() == id) {
                riderService.DeleteByTeamId(id);
                teamRepo.delete(obj);
            }
        }
    }
}
