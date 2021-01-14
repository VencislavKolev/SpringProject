package com.javatechnologies.springdemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String motorcycleBrand;

    private int totalPoints;

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

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }
}