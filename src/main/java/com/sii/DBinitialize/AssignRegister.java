package com.sii.DBinitialize;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sii.dao.CourseDaoImpl;
import com.sii.dao.StudentCourseDaoImpl;
import com.sii.dao.StudentDaoImpl;
import com.sii.entity.Course;
import com.sii.entity.Student;
import com.sii.entity.StudentCourse;

@Component
public class AssignRegister {

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Autowired
	private CourseDaoImpl courseDaoImpl;

	@Autowired
	private StudentCourseDaoImpl studentCourseDaoImpl;

	/**
	 * Here I assign a Student RAFI to a Course of PYHTON But i don't update the
	 * registrationDate This way I will see in DB that the Mapping between Course to
	 * StudentCourse is working How? By seeing that I have the course_id number in
	 * the table of StudentCourse And now I can do SQL queries related to Course and
	 * StudentCourse (But not SQL queries to Student because I didn't update the
	 * column of student_id in StudentCourse table) I wil do it when I will register
	 * a Student to StudentCourse
	 */
	public void assignStudentToCourse(String coursename, String studentIdentity) {
		Course course = courseDaoImpl.getCourseByCoursename(coursename);
		// Create a StundetCourse
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudentIdentity(studentIdentity);
		studentCourse.setCourseNumber(course.getCourseNumber());
		course.addStudentCourse(studentCourse);
		courseDaoImpl.updateCourse(course);
	}

	/**
	 * Here I'm registering the Student to the course. Question : What's the
	 * difference between assigning to registering? Answer: I did it for myself in
	 * order. When assgining the course_id is updated in table of StudentCourse,
	 * this way I can do SQL query between tables. When registering : 1. I update
	 * the StudentCourse registrationDate , 2. I update the Student table this way
	 * the mapping I will see the student_id number in the table of StudentCourse
	 * And now I could to queries on both tables since the mapping is now done from
	 * both sides
	 */
	public void registerStudentToCourse(String coursename, String studentIdentity) {

		Student student = studentDaoImpl.findByStudentIdentificationNumebr(studentIdentity);
		Course course = courseDaoImpl.getCourseByCoursename(coursename);

		StudentCourse studentCourse = studentCourseDaoImpl.getStudentCourse(studentIdentity, course.getCourseNumber());
		studentCourse.setRegistrationDate(LocalDate.of(2021, 4, 2));
		student.addStudentCourse(studentCourse);
		studentDaoImpl.updateStudent(student);
	}
}
