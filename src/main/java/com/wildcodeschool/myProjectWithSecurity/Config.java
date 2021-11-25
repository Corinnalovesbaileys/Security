package com.wildcodeschool.myProjectWithSecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers("/").permitAll()
                        .antMatchers("/avengers/assemble/**").hasRole("HEROE")
                        .antMatchers("/secretbases/**").hasRole("DIRI")
                .anyRequest().authenticated())
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("password"))
                .roles("")
                .and()
                .withUser("heroe")
                .password(encoder.encode("batman"))
                .roles("HEROE")
                .and()
                .withUser("Steve Guy")
                .password(encoder.encode("batman1"))
                .roles("HEROE")
                .and()
                .withUser("Tony Stark")
                .password(encoder.encode("batman2"))
                .roles("HEROE")
                .and()
                .withUser("director")
                .password(encoder.encode("kingkong"))
                .roles("DIRI")
                .and()
                .withUser("Nick Fury")
                .password(encoder.encode("kingkong1"))
                .roles("DIRI");

    }

}
