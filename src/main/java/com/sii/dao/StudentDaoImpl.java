package com.sii.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sii.entity.Student;
import com.sii.repository.StudentRepo;

@Service
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void createStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(long id) {
		studentRepo.deleteById(id);
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepo.findById(id).get();
	}

}
