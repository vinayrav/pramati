package com.practice.demo;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 @Bean
 @Override
 protected UserDetailsService userDetailsService() {


  List < UserDetails > users = new ArrayList < > ();
  users.add(User.withDefaultPasswordEncoder().username("vny").password("qwerty").roles("USER").build());

  return new InMemoryUserDetailsManager(users);

 }
 @Override
 protected void configure(HttpSecurity http) throws Exception {
  http.authorizeRequests().antMatchers("/h2-console/**")
   .permitAll().and()
   .authorizeRequests()
   .antMatchers("/**").authenticated()
   .anyRequest().permitAll()
   .and()
   .formLogin()
   .and()
   .httpBasic();
  http.csrf().disable();
  http.headers().frameOptions().disable();
 }
}