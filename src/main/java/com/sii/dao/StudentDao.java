package com.sii.dao;

import java.util.Set;

import com.sii.entity.Student;
import com.sii.entity.StudentCourse;

public interface StudentDao {

	void createStudent(Student student);
	
	Student getStudentById(long id);
	
	void updateStudent(Student student);
	
	void deleteStudentById(long id);
	
	Student findByStudentIdentificationNumebr(String identificationNumber);
	
	Set<StudentCourse> getCoursePerStudentIdent(String studentIdent);

}
