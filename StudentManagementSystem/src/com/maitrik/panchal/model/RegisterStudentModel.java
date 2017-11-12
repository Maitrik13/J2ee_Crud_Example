package com.maitrik.panchal.model;

public class RegisterStudentModel {
	
	public RegisterStudentModel() {
		super();
	}

	private String id;
	private String studentName;
	private String course;
	private String branch;
	private String rollNumber;
	private String email;
	private String userName;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegisterStudent [id=" + id + ", studentName=" + studentName + ", course=" + course + ", branch="
				+ branch + ", rollNumber=" + rollNumber + ", email=" + email + ", userName=" + userName + ", password="
				+ password + "]";
	}
	
	

	public RegisterStudentModel(String id, String studentName, String course, String branch, String rollNumber,
			String email, String userName, String password) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.course = course;
		this.branch = branch;
		this.rollNumber = rollNumber;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	
	
}
