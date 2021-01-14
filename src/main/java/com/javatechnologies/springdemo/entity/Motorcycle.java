package com.javatechnologies.springdemo.entity;

import javax.persistence.*;


@Entity
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String model;
    private Integer engineSize;
    private String color;

    @OneToOne
    @MapsId
    @JoinColumn(name = "rider_id")
    private Rider rider;

    public Motorcycle() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Integer engineSize) {
        this.engineSize = engineSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }
}
