//package com.javatechnologies.springdemo.configuration;
//
//import java.util.Optional;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.javatechnologies.springdemo.entity.User;
//import com.javatechnologies.springdemo.service.UserRepo;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserRepo userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepo.findByUserName(username);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found" + username));
//
//        return user.map(MyUserDetails::new).get();
//    }
//
//}
