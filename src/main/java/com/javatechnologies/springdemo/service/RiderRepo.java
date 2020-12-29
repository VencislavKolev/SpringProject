package com.javatechnologies.springdemo.service;

import com.javatechnologies.springdemo.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepo extends JpaRepository<Rider,Integer> {
}
