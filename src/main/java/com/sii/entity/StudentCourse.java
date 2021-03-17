package com.sii.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentCourse")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String studentIdent;
	private int courseNumber;
	private int grade;

	private LocalDate registrationDate;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public StudentCourse() {
		super();
	}

	public StudentCourse(String studentIdent, int courseNumber) {
		super();
		this.studentIdent = studentIdent;
		this.courseNumber = courseNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentIdent() {
		return studentIdent;
	}

	public void setStudentIdent(String studentIdent) {
		this.studentIdent = studentIdent;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

//	@Override
//	public String toString() {
//		return "StudentCourse [id=" + id + ", studentIdent=" + studentIdent + ", courseNumber=" + courseNumber
//				+ ", grade=" + grade + ", registrationDate=" + registrationDate + ", student=" + student + ", course="
//				+ course + "]";
//	}

}
