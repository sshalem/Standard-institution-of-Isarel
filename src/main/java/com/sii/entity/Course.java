package com.sii.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int courseNumber;
	private String courseName;
	private int year;
	private LocalDate startDate;
	private LocalDate endDate;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<StudentCourse> studentCourse = new HashSet<>();

	public Course() {
		super();
	}

	public Course(int courseNumber, String courseName, int year, LocalDate startDate, LocalDate endDate) {
		super();
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.year = year;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Set<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public void addStudentCourse(StudentCourse studentCourse) {
		this.studentCourse.add(studentCourse);
		studentCourse.setCourse(this);
	}

	public void removeStudentCourse(StudentCourse studentCourse) {
		this.studentCourse.remove(studentCourse);
		studentCourse.setCourse(this);
	}

//	@Override
//	public String toString() {
//		return "Course [id=" + id + ", courseNumber=" + courseNumber + ", courseName=" + courseName + ", year=" + year
//				+ ", startDate=" + startDate + ", endDate=" + endDate + ", studentCourse=" + studentCourse + "]";
//	}

}
