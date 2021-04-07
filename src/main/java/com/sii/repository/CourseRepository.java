package com.sii.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Course findByCourseName(String courseName);

	// returns list of "StudentCourse" ,which is searched by courseNumber from field
	// in StudentCourse entity.
	// from the received set of "StudentCourse" i can check for a Specific Course
	// which Students are :
	// 1. assigned to
	// 2. registered to
	@Query("SELECT sc FROM Course course JOIN course.studentCourse AS sc WHERE sc.courseNumber=:courseNumber")
	public Set<StudentCourse> getAllStudentsAssignedOrRegisteredToCourse(@Param("courseNumber") int courseNumber);

}
