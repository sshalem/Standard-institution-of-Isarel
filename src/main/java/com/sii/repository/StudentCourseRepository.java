package com.sii.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

	// returns a LIST of courses for a certain Student , by searching the studentIdentity
	@Query("SELECT course FROM StudentCourse sc JOIN sc.course as course WHERE sc.studentIdentity=:studentIdentity")
	public Set<Course> getCoursesOfStudent(@Param("studentIdentity") String studentIdentity);

	// returns a StudentCourse by searching studentIdentity And courseNumber.
	@Query("SELECT sc FROM StudentCourse sc WHERE sc.studentIdentity=:studentIdentity AND sc.courseNumber=:courseNumber")
	public StudentCourse getStudentCourseByStudentAndCourseNumber(@Param("studentIdentity") String studentIdent, @Param("courseNumber") int courseNumber);
}
