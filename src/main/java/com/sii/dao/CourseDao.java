package com.sii.dao;

import java.util.Set;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

public interface CourseDao {

	void createCourse(Course course);

	Course getCourseById(long id);

	void updateCourse(Course course);

	void deleteCourseById(long id);

	Set<StudentCourse> getListOfAssignedOrRegistredStudentsToCourse(int courseNumber);

}
