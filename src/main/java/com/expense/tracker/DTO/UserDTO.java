package com.expense.tracker.DTO;




import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import com.expense.tracker.Entity.User;

@Component
public class UserDTO {
	private Long userId;
	@NotNull(message = "First name can not be null")
	@Pattern(regexp = "[A-Za-z]{0,15}" , message = "Firstname should be maximum of 15 Alphabet characters")
	private String firstName;
	@NotNull(message = "Last name can not be null")
	@Pattern(regexp = "[A-Za-z]{0,15}" , message = "Firstname should be maximum of 15 Alphabet characters")
	private String lastName;
	@NotNull
	@Max((long)9999999999L)
	@Min((long)1000000000L)
	private Long phoneNumber;
	@NotNull(message="emailId can not be null")
	@Email(message = "Invalid Email")
	private String emailId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getEntity() {
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmailId(emailId);
		newUser.setPhoneNumber(phoneNumber);
		return newUser;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + "]";
	}
	

}
