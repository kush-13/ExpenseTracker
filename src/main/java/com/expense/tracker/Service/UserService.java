package com.expense.tracker.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.tracker.DTO.UserDTO;
import com.expense.tracker.Entity.User;
import com.expense.tracker.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public boolean isUserExists(Long userId) {
		return userRepository.findById(userId).isPresent();
	}

	public String notFoundMessage(Long userId) {
		return String.format("User with userId : {} does not exist !", userId);
	}

	public User saveUser(@Valid UserDTO userDTO) {
		return userRepository.save(userDTO.getEntity());
	}

}
