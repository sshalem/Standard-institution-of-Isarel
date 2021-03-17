package com.sii.facade;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sii.dao.StudentCourseDaoImpl;
import com.sii.dao.StudentDaoImpl;
import com.sii.entity.Course;
import com.sii.entity.Student;

@Service
@Scope("prototype")
public class StudentFacade {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Autowired
	private StudentCourseDaoImpl studentCourseDaoImpl;
	
	public Student getStudentByStudentIdentification(String identificationNumber) {
		return studentDaoImpl.findByStudentIdentificationNumebr(identificationNumber);
	}

	public Set<Course> getAllCoursesForStudentByStudentIdentity(String studentIdent) {
		return studentCourseDaoImpl.getAllCoursesOfStudentPerId(studentIdent);
	}

}
