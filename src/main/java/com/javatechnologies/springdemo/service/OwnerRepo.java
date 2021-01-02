package com.javatechnologies.springdemo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechnologies.springdemo.entity.Owner;

public interface OwnerRepo  extends JpaRepository<Owner,Integer>{

}
