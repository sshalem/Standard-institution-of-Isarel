package com.sii.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

public interface CourseRepository extends JpaRepository<Course, Long> {

	// this returns list of StudentCourse ,which is searched by courseNumber from field in StudentCourse entity
	// practically it will return a List of Students who are assigned/registered  to a certain course
	@Query("SELECT sc FROM Course course JOIN course.studentCourse AS sc WHERE sc.courseNumber=:courseNumber")
	public Set<StudentCourse> getListOfAssignedOrRegisteredStudentsToCourse(@Param("courseNumber") int courseNumber);

}
