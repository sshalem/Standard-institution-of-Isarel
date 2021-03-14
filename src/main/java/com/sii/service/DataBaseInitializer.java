package com.sii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sii.dao.StudentDaoImpl;
import com.sii.entity.Course;
import com.sii.entity.Student;
import com.sii.facade.CourseFacade;

@Component
public class DataBaseInitializer implements CommandLineRunner {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Autowired
	private CourseFacade courseFacade;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		/**
		 * Here I initialize the APP with students
		 */

		String odelPassword = passwordEncoder.encode("odel");
		Student odel = new Student("אודל", "שלם", "1111", odelPassword, "odel.shalem@gmail.com");
		studentDaoImpl.createStudent(odel);

		String avigailPassword = passwordEncoder.encode("avigail");
		Student avigail = new Student("אביגיל", "שלם", "2222", avigailPassword, "avigail.shalem@gmail.com");
		studentDaoImpl.createStudent(avigail);

		String arielPassword = passwordEncoder.encode("ariel");
		Student ariel = new Student("אריאל", "שלם", "3333", arielPassword, "ariel.shalem@gmail.com");
		studentDaoImpl.createStudent(ariel);

		String itamarPassword = passwordEncoder.encode("itamar");
		Student itamar = new Student("איתמר", "שלם", "4444", itamarPassword, "itamar.shalem@gmail.com");
		studentDaoImpl.createStudent(itamar);

		/**
		 * Here I init the APP with Courses
		 */

		Course java = new Course("java1234", 2021);
		courseFacade.createCourse(java);

		Course python = new Course("python987", 2021);
		courseFacade.createCourse(python);

		Course javascript = new Course("javascript2", 2021);
		courseFacade.createCourse(javascript);

		Course angular = new Course("angular11", 2021);
		courseFacade.createCourse(angular);

		Course react = new Course("react7", 2021);
		courseFacade.createCourse(react);
		
		Course sql = new Course("sql1", 2021);
		courseFacade.createCourse(sql);
				
		Course html = new Course("html5", 2021);
		courseFacade.createCourse(html);

		Course css = new Course("css3", 2021);
		courseFacade.createCourse(css);
	}

}
