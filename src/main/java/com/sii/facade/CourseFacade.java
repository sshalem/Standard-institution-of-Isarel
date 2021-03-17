package com.sii.facade;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sii.dao.CourseDaoImpl;
import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

@Service
public class CourseFacade {

	@Autowired
	private CourseDaoImpl courseDaoImpl;

	public void createCourse(Course course) {
		courseDaoImpl.createCourse(course);
	}

	public Set<StudentCourse> getListOfAssignedCoursesToStudent(int courseNumber) {
		return courseDaoImpl.getListOfAssignedCoursesToStudent(courseNumber);
	}
}
