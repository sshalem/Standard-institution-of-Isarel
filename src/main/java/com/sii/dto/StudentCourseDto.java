package com.sii.dto;

import java.time.LocalDate;

import com.sii.common.Registration;

public class StudentCourseDto {

	private int courseNumber;
	private String courseName;
	private int grade;
	private LocalDate startDate;
	private LocalDate endDate;
	private Registration registration;

	public StudentCourseDto() {
		super();
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		return "StudentCourseDto [courseNumber=" + courseNumber + ", courseName=" + courseName + ", grade=" + grade
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", registration=" + registration + "]";
	}

}
