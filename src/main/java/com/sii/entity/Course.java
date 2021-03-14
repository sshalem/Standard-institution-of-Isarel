package com.sii.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String courseNumber;
	private int year;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	private Set<Student> students;

	public Course() {
		super();
	}

	public Course(String courseNumber, int year) {
		super();
		this.courseNumber = courseNumber;
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getYaer() {
		return year;
	}

	public void setYaer(int yaer) {
		this.year = yaer;
	}

	public Set<Student> getStudentList() {
		return students;
	}

	public void setStudentList(Set<Student> studentList) {
		this.students = studentList;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseNumber=" + courseNumber + ", yaer=" + year + ", studentList=" + students
				+ "]";
	}

}
