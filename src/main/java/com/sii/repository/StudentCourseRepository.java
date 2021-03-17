package com.sii.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

	@Query("SELECT course from StudentCourse sc JOIN sc.course as course WHERE sc.studentIdent=:studentIdent")
	public Set<Course> getCourseOfStudent(@Param("studentIdent") String studentIdent);

}
