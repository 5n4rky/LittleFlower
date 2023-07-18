package com.LittleFlower.staffinformationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DETAILS")
public class StudentDetailsEntity {
	
	@Id
	@Column(name = "STUDENT_IDENTIFIER")
	private long studentIdentifier;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String 	lastName;
	@Column(name = "PARENT_CONTACT_NUMBER")
	private long paretnsContactNumber;
	@Column(name = "GUARD_CONTACT_NUMBER")
	private long guradContactNumber;
	@Column(name = "ADDRESS_TEXT")
	private String addressText;
	@Column(name = "EMAIL_IDENTIFIER")
	private String emailIdentifier;
	@Column(name = "FATHER_NAME")
	private String fathersName;
	@Column(name = "MOTHER_NAME")
	private String MothersName;
	@Column(name="GRADE")
	private String grade;
	private final String role="student";
	public long getStudentIdentifier() {
		return studentIdentifier;
	}
	public void setStudentIdentifier(long studentIdentifier) {
		this.studentIdentifier = studentIdentifier;
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
	public long getParetnsContactNumber() {
		return paretnsContactNumber;
	}
	public void setParetnsContactNumber(long paretnsContactNumber) {
		this.paretnsContactNumber = paretnsContactNumber;
	}
	public long getGuradContactNumber() {
		return guradContactNumber;
	}
	public void setGuradContactNumber(long guradContactNumber) {
		this.guradContactNumber = guradContactNumber;
	}
	public String getAddressText() {
		return addressText;
	}
	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}
	public String getEmailIdentifier() {
		return emailIdentifier;
	}
	public void setEmailIdentifier(String emailIdentifier) {
		this.emailIdentifier = emailIdentifier;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return MothersName;
	}
	public void setMothersName(String mothersName) {
		MothersName = mothersName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRole() {
		return role;
	}
	
	
	
	
	
	
}
