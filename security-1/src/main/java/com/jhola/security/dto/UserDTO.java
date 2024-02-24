package com.jhola.security.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = -4982668184925760055L;

	@Email(message = "Username needs to be an email")
	@NotBlank(message = "username is required")
	private String username;

	@NotBlank(message = "Please enter your full name")
	private String fullName;

	@NotBlank(message = "Password field is required")
	private String password;

	private String confirmPassword;

	public UserDTO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	
}
