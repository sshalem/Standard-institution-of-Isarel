package com.sii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sii.dao.StudentDaoImpl;
import com.sii.entity.Student;

@Component
public class DataBaseInitializer implements CommandLineRunner{

	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		String odelPassword = passwordEncoder.encode("odel");		
		Student odel = new Student("odel", "shalem", "1234", odelPassword, "odel.shalem@gmail.com");		
		studentDaoImpl.createStudent(odel);
	}

}
