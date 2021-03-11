package com.sioi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sioi.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

//	@Query("SELECT courses FROM student st JOIN st.courseList AS courses WHERE st.firstName=:firstName")
//	Set<Course> getCoursesByStudentFirstName(@Param("firstName") String firstName);

	Student findByStudentIdent(String studentident);
}
