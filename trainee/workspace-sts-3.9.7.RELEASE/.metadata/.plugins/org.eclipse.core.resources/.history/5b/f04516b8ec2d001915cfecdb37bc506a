package com.practice.demo;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authprovider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
		
	}
	
	
//@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		
//		List<UserDetails> users= new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("vny").password("qwerty").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//		
//	}
@Override
protected void configure(HttpSecurity http) throws Exception {
	http
	.csrf().disable()
	.authorizeRequests().antMatchers("/login").permitAll()
	.antMatchers("/register.jsp")
	.permitAll()
	.antMatchers("/register")
	.permitAll()
	.anyRequest().authenticated()
	.and()
    .formLogin()
    .loginPage("/login").permitAll()
    .and()
    .logout().invalidateHttpSession(true)
    .clearAuthentication(true)
    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    //.logoutSuccessUrl("/logout-success").permitAll();
	

}
}




