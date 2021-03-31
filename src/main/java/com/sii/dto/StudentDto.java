package com.sii.dto;

public class StudentDto {

	private String studentIdentity;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public StudentDto() {
		super();
	}

	public StudentDto(String studentIdentity, String firstName, String lastName, String email) {
		super();
		this.studentIdentity = studentIdentity;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = "*****";
	}

	public String getStudentIdentity() {
		return studentIdentity;
	}

	public void setStudentIdentity(String studentIdentity) {
		this.studentIdentity = studentIdentity;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentDto [studentIdentity=" + studentIdentity + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + "]";
	}

}
