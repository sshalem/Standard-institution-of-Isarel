package com.sii.dto;

import java.time.LocalDate;

public class StudentCourseDto {

	private int courseNumber;
	private String courseName;
	private int grade;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate registrationDate;

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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "StudentCourseDto [courseNumber=" + courseNumber + ", courseName=" + courseName + ", grade=" + grade
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", registrationDate=" + registrationDate + "]";
	}

}
