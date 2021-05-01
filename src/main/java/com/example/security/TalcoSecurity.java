package com.example.security;

import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class TalcoSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder encoder() {
	return new StandardPasswordEncoder("53cr3t");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) 
	throws Exception{
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(encoder());
	}
	
	@Override
	public void configure(HttpSecurity httpSec) throws Exception{
		httpSec.authorizeRequests()
			.antMatchers("/design", "/orders")
				.hasRole("USER")
			.antMatchers("/", "/**")
				.permitAll()
		.and()
			.formLogin()
				.loginPage("/login");
	}
}
