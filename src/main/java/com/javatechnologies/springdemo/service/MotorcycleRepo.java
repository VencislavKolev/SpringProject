package com.javatechnologies.springdemo.service;

import com.javatechnologies.springdemo.entity.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepo extends JpaRepository<Motorcycle, Integer> {
}
