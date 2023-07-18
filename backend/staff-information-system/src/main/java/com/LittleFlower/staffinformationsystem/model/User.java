package com.LittleFlower.staffinformationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_USER")
public class User {
	
	@Id
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ACTIVE")
	private String active;
	@Column(name = "ROLES")
    private String roles;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String isActive) {
		this.active = isActive;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", isActive=" + active + ", roles=" + roles
				+ "]";
	}
	
	
	

}
