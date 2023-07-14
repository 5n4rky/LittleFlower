package com.LittleFlower.staffinformationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STAFF_DETAILS")
public class StaffDetailsEntity {
	@Id
	@Column(name = "STAFF_IDENTIFIER")
	/* @JsonIgnore */
	private long staffIdentifier;
	@Column(name = "STAFF_NAME")
	private String staffName;
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

	
	  
	  @Override public String toString() { return
	  "StaffDetailsEntity [staffIdentifier=" + staffIdentifier + ", staffName=" +
	  staffName + ", primaryContactNumber=" + primaryContactNumber +
	 ", secondaryContactNumber=" + secondaryContactNumber + ", emailIdentifier=" +
	 emailIdentifier + ", whatsappNumber=" + whatsappNumber + "]"; }
	 
	public long getStaffIdentifier() {
		return staffIdentifier;
	}

	public void setStaffIdentifier(long staffIdentifier) {
		this.staffIdentifier = staffIdentifier;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
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

}
