package com.sioi.dao;

import com.sioi.entity.Student;

public interface StudentDao {

	void createStudent(Student student);
	
	Student getStudentById(long id);
	
	void updateStudent(Student student);
	
	void deleteStudentById(long id);

}
