package com.sii.rest;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sii.entity.StudentCourse;
import com.sii.facade.CourseFacade;

@RestController
@RequestMapping("/course")
public class CourseRestControler {

	private static Logger LOGGER = LoggerFactory.getLogger(CourseRestControler.class);

	@Autowired
	private CourseFacade courseFacade;

	@GetMapping("/{courseNumber}")
	public Set<StudentCourse> getAssignedCoursesToStudentPerCourseNumber(@PathVariable("courseNumber") int courseNumber) {
		LOGGER.info("from CourseRestControler");
		return courseFacade.listOfAssignedOrRegistredStudentsToCourse(courseNumber);
	}
}
