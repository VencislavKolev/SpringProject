package com.javatechnologies.springdemo.service;

import com.javatechnologies.springdemo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team,Integer> {
}
