package com.javatechnologies.springdemo.controller;

import com.javatechnologies.springdemo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.javatechnologies.springdemo.configuration.MyUserDetailsService;

@RestController
public class UserController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @PostMapping(value = "/register")
    public void RegisterUser(@RequestBody User user){
        myUserDetailsService.saveUser(user);
    }

    @GetMapping("/")
    public String home() {

        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {

        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {

        return ("<h1>Welcome Admin</h1>");
    }
}
