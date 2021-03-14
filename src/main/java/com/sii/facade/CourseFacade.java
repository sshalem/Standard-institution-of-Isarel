package com.sii.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sii.dao.CourseDaoImpl;
import com.sii.entity.Course;

@Service
public class CourseFacade {

	@Autowired
	private CourseDaoImpl courseDaoImpl;

	public void createCourse(Course course) {
		courseDaoImpl.createCourse(course);
	}
}
