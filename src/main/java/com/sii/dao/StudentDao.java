package com.sii.dao;

import com.sii.entity.Student;

public interface StudentDao {

	void createStudent(Student student);
	
	Student getStudentById(long id);
	
	void updateStudent(Student student);
	
	void deleteStudentById(long id);
	
	Student findByStudentIdentificationNumebr(String identificationNumber);

}
