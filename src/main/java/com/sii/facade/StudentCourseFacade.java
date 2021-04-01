package com.sii.facade;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sii.common.Registration;
import com.sii.dao.StudentCourseDaoImpl;
import com.sii.dto.StudentCourseDto;
import com.sii.entity.Course;
import com.sii.entity.StudentCourse;

@Service
@Scope("prototype")
public class StudentCourseFacade {

	@Autowired
	private StudentCourseDaoImpl studentCourseDaoImpl;

	public Set<StudentCourseDto> getAllCoursesForStudentByStudentIdentity(String studentIdent) {

		Set<StudentCourseDto> studentCoursesDto = new HashSet<>();

		Set<Course> coursesOfStudent = studentCourseDaoImpl.getAllCoursesOfStudentPerId(studentIdent);

		for (Course course : coursesOfStudent) {
			StudentCourse studentCourse = studentCourseDaoImpl.getStudentCourse(studentIdent, course.getCourseNumber());
			StudentCourseDto studentCourseDto = new StudentCourseDto();
			studentCourseDto.setCourseNumber(course.getCourseNumber());
			studentCourseDto.setCourseName(course.getCourseName());
			studentCourseDto.setGrade(studentCourse.getGrade());
			studentCourseDto.setStartDate(course.getStartDate());
			studentCourseDto.setEndDate(course.getEndDate());

			if (studentCourse.getRegistrationDate() == null) {
				studentCourseDto.setRegistration(Registration.UNREGISTERED);
			} else if (studentCourse.getRegistrationDate().isBefore(course.getStartDate())) {
				studentCourseDto.setRegistration(Registration.REGISTERED);
			}

			studentCoursesDto.add(studentCourseDto);

		}

		return studentCoursesDto;
	}

}
