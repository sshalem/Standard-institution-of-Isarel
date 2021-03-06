package com.sii.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sii.entity.Course;
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

}
