package com.javatechnologies.springdemo.service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechnologies.springdemo.entity.Car;

public interface CarRepo extends JpaRepository<Car,Integer>{

}
