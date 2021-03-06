package com.javatechnologies.springdemo.entity;

import javax.persistence.*;

@Entity
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullname;
    private String email;
    private int age;
    private int racenumber;

    private int teamId;


    public Rider() {
        super();
    }

    public Integer getId() {
        return id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRacenumber() {
        return racenumber;
    }

    public void setRacenumber(int racenumber) {
        this.racenumber = racenumber;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }


}
