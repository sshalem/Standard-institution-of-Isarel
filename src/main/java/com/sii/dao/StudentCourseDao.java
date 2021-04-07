package com.sii.dao;

import java.util.Set;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

public interface StudentCourseDao {

	Set<Course> getAllCoursesOfStudentAssignedOrRegistered(String studentId);

	StudentCourse getStudentCourse(String studentId, int courseNumber);
}
