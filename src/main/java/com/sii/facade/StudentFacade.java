package com.sii.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sii.dao.StudentDaoImpl;
import com.sii.entity.Student;

@Service
public class StudentFacade {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	public void assignCourse(Student student) {
		
	}

}
