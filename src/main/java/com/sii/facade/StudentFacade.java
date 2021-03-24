package com.sii.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sii.dao.StudentDaoImpl;
import com.sii.dto.StudentDto;
import com.sii.entity.Student;

@Service
@Scope("prototype")
public class StudentFacade {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	public Student getStudentByStudentIdentification(String identificationNumber) {
		return studentDaoImpl.findByStudentIdentificationNumebr(identificationNumber);
	}

	public StudentDto updateStudentDetails(StudentDto studentDto) {
		Student student = studentDaoImpl.findByStudentFirstnameAndLastnameAndStudentIdentity(studentDto.getFirstName(),
				studentDto.getLastName(), studentDto.getStudentIdentity());

		student.setEmail(studentDto.getEmail());
		studentDaoImpl.updateStudent(student);
		
		StudentDto updatedStudentDto = new StudentDto(student.getFirstName(), student.getLastName(),
				student.getStudentIdent(), student.getEmail());
		return updatedStudentDto;
	}

}
