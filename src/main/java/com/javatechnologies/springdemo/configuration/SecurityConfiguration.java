package com.javatechnologies.springdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
        auth.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                csrf().disable()
                    .authorizeRequests()
                        .antMatchers("/admin").hasRole("ADMIN")
                        .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                        .antMatchers("/team/**").hasRole("ADMIN")
                        .antMatchers("/motorcycle/**").hasRole("ADMIN")
                        .antMatchers("/rider/**").hasRole("ADMIN")
                        .antMatchers("/register").permitAll()
                        .antMatchers("/").permitAll()
                    .anyRequest()
                    .authenticated()
                .and().formLogin()
                .and().httpBasic();
    }
}
