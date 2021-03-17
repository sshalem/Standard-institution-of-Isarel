package com.sii.dao;

import java.util.Set;

import com.sii.entity.Course;

public interface StudentCourseDao {

	Set<Course> getAllCoursesOfStudentPerId(String studentId);
}
