package com.sioi.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sioi.dao.StudentDaoImpl;
import com.sioi.entity.Student;

@Service
public class StudentFacade {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	public void assignCourse(Student student) {
		
	}

}
