package com.javatechnologies.springdemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String motorcycleBrand;
    private Integer totalPoints;

    @OneToMany(targetEntity = Rider.class, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "teamId", referencedColumnName = "id")
    private List<Rider> riders;

    public Team() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotorcycleBrand() {
        return motorcycleBrand;
    }

    public void setMotorcycleBrand(String manufacturer) {
        this.motorcycleBrand = manufacturer;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
}