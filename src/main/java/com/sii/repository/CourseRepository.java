package com.sii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sii.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
