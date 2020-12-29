package com.javatechnologies.springdemo.entity;

import javax.persistence.*;

@Entity
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullname;
    private String email;
    private Integer age;
    private Integer racenumber;
    private Integer teamId;


//    @ManyToOne(targetEntity = Motorcycle.class, orphanRemoval = true, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "motorcycleId")
//    //    private Integer motorcycleId;
//        private Motorcycle motorcycle;
//
//    @ManyToOne(targetEntity = Team.class, orphanRemoval = true, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "teamId")
//    //private Integer teamId;
//    private Team team;

    public Rider() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRacenumber() {
        return racenumber;
    }

    public void setRacenumber(int racenumber) {
        this.racenumber = racenumber;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
//    public Motorcycle getMotorcycle() {
//        return motorcycle;
//    }
//
//    public void setMotorcycle(Motorcycle motorcycle) {
//        this.motorcycle = motorcycle;
//    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public Integer getMotorcycleId() {
//        return motorcycleId;
//    }
//
//    public void setMotorcycleId(Integer motorcycleId) {
//        this.motorcycleId = motorcycleId;
//    }
//
//    public Integer getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Integer teamId) {
//        this.teamId = teamId;
//    }
}
