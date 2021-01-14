package com.javatechnologies.springdemo.configuration;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.javatechnologies.springdemo.entity.User;
import com.javatechnologies.springdemo.service.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepo.findAll().size() == 0) {
            user.setRoles("ROLE_ADMIN");
        }
        this.userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found" + username));

        MyUserDetails myUser = user.map(MyUserDetails::new).get();
        //myUser.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));
        return myUser;
    }
}
