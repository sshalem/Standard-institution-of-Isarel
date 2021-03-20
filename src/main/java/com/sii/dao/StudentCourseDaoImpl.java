package com.sii.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;
import com.sii.repository.StudentCourseRepository;

@Service
public class StudentCourseDaoImpl implements StudentCourseDao {

	@Autowired
	private StudentCourseRepository studentCourseRepository;

	@Override
	public Set<Course> getAllCoursesOfStudentPerId(String studentId) {
		return studentCourseRepository.getCoursesOfStudent(studentId);
	}

	@Override
	public StudentCourse getStudentCourse(String studentId, int courseNumber) {
		return studentCourseRepository.getStudentCourseByStudentAndCourseNumber(studentId, courseNumber);
	}

}
