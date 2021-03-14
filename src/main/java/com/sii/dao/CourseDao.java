package com.sii.dao;

import com.sii.entity.Course;

public interface CourseDao {

	void createCourse(Course course);

	Course getCourseById(long id);

	void updateCourse(Course course);

	void deleteCourseById(long id);

}
