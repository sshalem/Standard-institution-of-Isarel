package com.sii.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sii.entity.Course;
import com.sii.entity.StudentCourse;
import com.sii.repository.CourseRepository;

@Service
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public void createCourse(Course course) {
		courseRepo.save(course);
	}

	@Override
	public Course getCourseById(long id) {
		return courseRepo.getOne(id);
	}

	@Override
	public void updateCourse(Course course) {
		courseRepo.save(course);
	}

	@Override
	public void deleteCourseById(long id) {
		courseRepo.deleteById(id);
	}

	@Override
	public Course getCourseByCoursename(String courseName) {
		return courseRepo.findByCourseName(courseName);
	}

	/**
	 * from the received set of "StudentCourse" i can check for a Specific Course
	 * which Students are : 1. assigned to him 2. registered to him
	 */
	@Override
	public Set<StudentCourse> getListOfStudentsAssignedOrRegisteredToCourse(int courseNumber) {
		return courseRepo.getAllStudentsAssignedOrRegisteredToCourse(courseNumber);
	}

}
