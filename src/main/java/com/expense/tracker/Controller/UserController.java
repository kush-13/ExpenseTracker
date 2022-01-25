package com.expense.tracker.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.DTO.UserDTO;
import com.expense.tracker.Entity.User;
import com.expense.tracker.Service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userHandler;

	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO) {
		User user = userHandler.saveUser(userDTO);
		System.out.println("creates User : " + user);
		return ResponseEntity.ok("User registeration sucessfull !!");
	}
}
