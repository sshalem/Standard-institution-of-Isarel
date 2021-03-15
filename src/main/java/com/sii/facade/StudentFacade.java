package com.sii.facade;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sii.dao.StudentDaoImpl;
import com.sii.entity.Student;
import com.sii.entity.StudentCourse;

@Service
@Scope("prototype")
public class StudentFacade {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	public Student getByStudentIdentification(String identificationNumber) {
		return studentDaoImpl.findByStudentIdentificationNumebr(identificationNumber);
	}

	public Set<StudentCourse> getAllCoursesByStudentIdent(String studentIdent) {
		return studentDaoImpl.getCoursePerStudentIdent(studentIdent);
	}

}
