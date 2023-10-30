package com.sammy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	public CustomAuthSuccessHandler successHandler;
	
	@Autowired
	public CustomFailureHandler failureHandler;

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService getDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
			DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
			daoAuthenticationProvider.setUserDetailsService(getDetailsService());
			daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
			return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		
		/*
		 * http.csrf().disable()
		 * .authorizeHttpRequests().antMatchers("/","/register","/signin","/saveUser").
		 * permitAll() .antMatchers("/user/**").authenticated().and()
		 * .formLogin().loginPage("/signin").loginProcessingUrl("/userLogin") //
		 * .usernameParameter("email") .defaultSuccessUrl("/user/profile").permitAll();
		 */
		
		http.csrf().disable()
		.authorizeHttpRequests().antMatchers("/user/**").hasRole("USER")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/**").permitAll().and()
		.formLogin().loginPage("/signin").loginProcessingUrl("/userLogin")
		.failureHandler(failureHandler)
		.successHandler(successHandler)
		.permitAll();
		
		
		
		return http.build();
	}
}
