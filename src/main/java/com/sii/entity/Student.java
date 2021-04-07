package com.sii.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@SequenceGenerator(name = "studentseq", initialValue = 20001, allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentseq")
	@Column(name = "student_id")
	private long id;
	private String firstName;
	private String lastName;
	private String studentIdentity;
	private String encryptedPassword;
	private String email;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<StudentCourse> studentCourse = new HashSet<>();

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String studentIdentity, String encryptedPassword, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentIdentity = studentIdentity;
		this.encryptedPassword = encryptedPassword;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentIdentity() {
		return studentIdentity;
	}

	public void setStudentIdentity(String studentIdentity) {
		this.studentIdentity = studentIdentity;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Set<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public void addStudentCourse(StudentCourse studentCourse) {
		this.studentCourse.add(studentCourse);
		studentCourse.setStudent(this);
	}

	public void removeStudentCourse(StudentCourse studentCourse) {
		this.studentCourse.remove(studentCourse);
		studentCourse.setStudent(this);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", studentIdentity="
				+ studentIdentity + ", encryptedPassword=" + encryptedPassword + ", email=" + email + "]";
	}

}
