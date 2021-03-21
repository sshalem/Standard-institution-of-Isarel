package com.sii.rest;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sii.dto.StudentCourseDto;
import com.sii.facade.StudentCourseFacade;

@RestController
@RequestMapping("/studentcourse")
@Scope("prototype")
public class StudentCourseRestController {

	private static Logger LOGGER = LoggerFactory.getLogger(StudentCourseRestController.class);

	@Autowired
	private StudentCourseFacade studentCourseFacade;

	/**
	 * 
	 * @param identity
	 * @return StudentCourseDto - returns all courses assigned to a Student
	 */
	@GetMapping(path = "/all/{identity}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<StudentCourseDto> getStudentCoursesPerStudentIdentity(@PathVariable("identity") String identity) {
		LOGGER.info("Get method ");
		return studentCourseFacade.getAllCoursesForStudentByStudentIdentity(identity);
	}
}
