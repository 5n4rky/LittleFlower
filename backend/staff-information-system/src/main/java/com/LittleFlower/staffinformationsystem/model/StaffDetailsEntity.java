package com.LittleFlower.staffinformationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAFF_DETAILS")
public class StaffDetailsEntity {
	@Id
	@Column(name = "STAFF_IDENTIFIER")
	/* @JsonIgnore */
	private long staffIdentifier;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String 	lastName;
	@Column(name = "PRIMARY_CONTACT_NUMBER")
	private long primaryContactNumber;
	@Column(name = "SECONDARY_CONTACT_NUMBER")
	private long secondaryContactNumber;
	@Column(name = "ADDRESS_TEXT")
	private String addressText;
	@Column(name = "EMAIL_IDENTIFIER")
	private String emailIdentifier;
	@Column(name = "WHATSAPP_NUMBER")
	private long whatsappNumber;
	@Column(name ="ROLE")
	private  String role;
	@Column(name="CLASS_OWNED")
	private String classOwned;
	public long getStaffIdentifier() {
		return staffIdentifier;
	}
	public void setStaffIdentifier(long staffIdentifier) {
		this.staffIdentifier = staffIdentifier;
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
	public long getPrimaryContactNumber() {
		return primaryContactNumber;
	}
	public void setPrimaryContactNumber(long primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}
	public long getSecondaryContactNumber() {
		return secondaryContactNumber;
	}
	public void setSecondaryContactNumber(long secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
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
	public long getWhatsappNumber() {
		return whatsappNumber;
	}
	public void setWhatsappNumber(long whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getClassOwned() {
		return classOwned;
	}
	public void setClassOwned(String classOwned) {
		this.classOwned = classOwned;
	}
	
	
	
	

	
	  
	  
	

}
