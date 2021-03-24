package com.sii.dto;

public class StudentDto {

	private String firstName;
	private String lastName;
	private String studentIdentity;
	private String password;
	private String email;

	public StudentDto() {
		super();
	}

	public StudentDto(String firstName, String lastName, String studentIdentity, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentIdentity = studentIdentity;
		this.password = "*****";
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "StudentDto [firstName=" + firstName + ", lastName=" + lastName + ", studentIdentity=" + studentIdentity
				+ ", password=" + password + ", email=" + email + "]";
	}

}
