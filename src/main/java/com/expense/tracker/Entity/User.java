package com.expense.tracker.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Column(unique = true, nullable = false)
	private Long phoneNumber;
	@Column(unique = true, nullable = false)
	private String emailId;

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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return String.format("[ %d | %s | %s | %s | %d] ", userId, firstName, lastName, emailId, phoneNumber);
	}

}
