package com.sioi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.sioi.service.StudentUserDetails;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	private StudentUserDetails studentUserDetails;
	
	@Autowired
	public WebSecurityConfig(StudentUserDetails studentUserDetails) {
		this.studentUserDetails = studentUserDetails;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(studentUserDetails);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	}
}
