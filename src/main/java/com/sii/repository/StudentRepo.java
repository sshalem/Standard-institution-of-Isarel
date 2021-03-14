package com.sii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sii.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

//	@Query("SELECT courses FROM student st JOIN st.courseList AS courses WHERE st.firstName=:firstName")
//	Set<Course> getCoursesByStudentFirstName(@Param("firstName") String firstName);

	Student findBystudentIdentity(String studentidentityNumber);
}
