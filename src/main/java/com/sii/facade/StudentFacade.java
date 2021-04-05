package com.sii.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sii.dao.StudentDaoImpl;
import com.sii.dto.StudentDto;
import com.sii.entity.Student;

@Service
@Scope("prototype")
public class StudentFacade {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Student getStudentByStudentIdentification(String identificationNumber) {
		return studentDaoImpl.findByStudentIdentificationNumebr(identificationNumber);
	}

	public StudentDto updateStudentDetails(StudentDto studentDto) {

		Student student = studentDaoImpl.findByStudentIdentificationNumebr(studentDto.getStudentIdentity());

		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setEncryptedPassword(passwordEncoder.encode(studentDto.getPassword()));

		studentDaoImpl.updateStudent(student);
		StudentDto updateStudentDto = new StudentDto(student.getStudentIdentity(), student.getFirstName(),
				student.getLastName(), student.getEmail());
		return updateStudentDto;
	}

}
