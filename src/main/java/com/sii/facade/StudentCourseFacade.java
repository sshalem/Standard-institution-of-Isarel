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

	public StudentCourse getStudentCourse(String studentIdentity, int courseNumber) {
		return studentCourseDaoImpl.getStudentCourse(studentIdentity, courseNumber);
	}

	/**
	 * 
	 * @param studentIdentity
	 * @return set of StudentCourseDto.
	 * 
	 */
	public Set<StudentCourseDto> coursesOfStudentAssignedOrRegistered(String studentIdentity) {

		Set<StudentCourseDto> studentCoursesDto = new HashSet<>();

		Set<Course> coursesOfStudent = studentCourseDaoImpl.getAllCoursesOfStudentAssignedOrRegistered(studentIdentity);

		for (Course course : coursesOfStudent) {
			StudentCourse studentCourse = studentCourseDaoImpl.getStudentCourse(studentIdentity,
					course.getCourseNumber());
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
			} else if (studentCourse.getRegistrationDate().isAfter(course.getStartDate())) {
				studentCourseDto.setRegistration(Registration.REGISTRATION_EXPIRED);
			}

			studentCoursesDto.add(studentCourseDto);

		}

		return studentCoursesDto;
	}

}
