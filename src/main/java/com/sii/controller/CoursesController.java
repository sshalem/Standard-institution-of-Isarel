package com.sii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sii.entity.Student;
import com.sii.facade.StudentFacade;

@Controller
public class CoursesController {

	private static Logger LOGGER = LoggerFactory.getLogger(CoursesController.class);

	@Autowired
	private StudentFacade studentFacade;

	@GetMapping("/courses")
	public String coursesPage(HttpServletRequest request, HttpServletResponse response) {

		Student student = studentFacade.getStudentByStudentIdentification(request.getUserPrincipal().getName());
		response.addHeader("studentID", student.getStudentIdentity());
		LOGGER.info(student.getFirstName() + " " + student.getLastName() + " --> is logged in the ");
		return "courses.html";
	}
}
