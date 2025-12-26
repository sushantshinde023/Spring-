package com.example.SpringSecurityCustomizedEx.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated() )
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
	}
	// The below method was using in memory users with sprin provided authentication provider
	/*
	@Bean
	public UserDetailsManager userDetailsManager() {
		
		UserDetails user= User.withDefaultPasswordEncoder()
				.username("sush")
				.password("s@123")
				.roles("ADMIN").build();
		
		
		return new InMemoryUserDetailsManager(user);
	}*/
	
	//we will customize authentication provider itself
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		//Authentictaion provider is an interface so will use DaoAuthenticationProvider
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		return provider;
	}

}
	
	