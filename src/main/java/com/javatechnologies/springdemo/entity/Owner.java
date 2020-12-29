//package com.javatechnologies.springdemo.entity;
//
//import sun.jvm.hotspot.gc.z.ZForwardingTable;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.swing.*;
//
//@Entity
//public class Owner {
//    @Id
//    @GeneratedValue
//    private int id;
//    private String name;
//    private String email;
//    private String address;
//
//    @OneToMany(targetEntity = Car.class, orphanRemoval = true, cascade = CascadeType.ALL)
//    @JoinColumn(name = "idOwner", referencedColumnName = "id")
//    private List<Car> cars;
//
//
//    public Owner() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
//
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//    public String getAddress() {
//        return address;
//    }
//
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//
//    public List<Car> getCars() {
//        return cars;
//    }
//
//
//    public void setCars(List<Car> cars) {
//        this.cars = cars;
//    }
//
//
//}
