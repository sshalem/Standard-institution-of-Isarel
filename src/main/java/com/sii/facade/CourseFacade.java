package com.sii.facade;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sii.dao.CourseDaoImpl;
import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

@Service
@Scope("prototype")
public class CourseFacade {

	@Autowired
	private CourseDaoImpl courseDaoImpl;

	public void createCourse(Course course) {
		courseDaoImpl.createCourse(course);
	}

	/**
	 * return All the students that are assigned/registered to a Course by courseNumber
	 */
	public Set<StudentCourse> listOfStudentsAssignedOrRegisteredToCourse(int courseNumber) {
		return courseDaoImpl.getListOfStudentsAssignedOrRegisteredToCourse(courseNumber);
	}
}
