package com.javatechnologies.springdemo.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechnologies.springdemo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	Optional<User>findByUserName(String userName);

}
