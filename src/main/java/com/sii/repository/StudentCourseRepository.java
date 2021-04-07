package com.sii.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

	// returns a LIST of "Courses" for a certain Student .
	// The set of "Course" will show :
	//	1. who is assigned too course or, Student is registered too
	@Query("SELECT course FROM StudentCourse sc JOIN sc.course as course WHERE sc.studentIdentity=:studentIdentity")
	public Set<Course> getAllCoursesOfStudentAssignedOrRegistered(@Param("studentIdentity") String studentIdentity);

	// returns a StudentCourse by searching studentIdentity And courseNumber.
	@Query("SELECT sc FROM StudentCourse sc WHERE sc.studentIdentity=:studentIdentity AND sc.courseNumber=:courseNumber")
	public StudentCourse findStudentCourse(@Param("studentIdentity") String studentIdentity, @Param("courseNumber") int courseNumber);

}
