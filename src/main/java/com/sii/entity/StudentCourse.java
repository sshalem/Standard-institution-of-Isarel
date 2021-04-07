package com.sii.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String studentIdentity;
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

	public StudentCourse(String studentIdentity, int courseNumber, LocalDate registrationDate) {
		super();
		this.studentIdentity = studentIdentity;
		this.courseNumber = courseNumber;
		this.registrationDate = registrationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentIdentity() {
		return studentIdentity;
	}

	public void setStudentIdentity(String studentIdentity) {
		this.studentIdentity = studentIdentity;
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

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", studentIdentity=" + studentIdentity + ", courseNumber=" + courseNumber
				+ ", grade=" + grade + ", registrationDate=" + registrationDate + "]";
	}

//	@Override
//	public String toString() {
//		return "StudentCourse [id=" + id + ", studentIdentity=" + studentIdentity + ", courseNumber=" + courseNumber
//				+ ", grade=" + grade + ", registrationDate=" + registrationDate + ", student=" + student + ", course="
//				+ course + "]";
//	}
}
