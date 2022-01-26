package com.expense.tracker.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.DTO.DuesDTO;
import com.expense.tracker.Entity.Dues;
import com.expense.tracker.Exceptions.NoSuchUserException;
import com.expense.tracker.Service.DuesService;
import com.expense.tracker.Service.UserService;

@RestController
public class DuesController {
	@Autowired
	UserService userHandler;
	@Autowired
	DuesService duesHandler;

	@PostMapping("/recordDues")
	public ResponseEntity<String> recordDues(@RequestBody @Valid DuesDTO duesDTO) throws NoSuchUserException {

		// check if user/ower exists in db
		if (!userHandler.isUserExists(duesDTO.getUserId()))
			throw new NoSuchUserException(userHandler.notFoundMessage(duesDTO.getUserId()));
		if (!userHandler.isUserExists(duesDTO.getOwedUserId()))
			throw new NoSuchUserException(userHandler.notFoundMessage(duesDTO.getOwedUserId()));

		// record Expense
		Dues dues = duesHandler.saveDues(duesDTO);

		System.out.println("Dues Recorded !!" + dues);

		return new ResponseEntity<String>("Dues Recorded Sucessfully", HttpStatus.OK);
	}

	@GetMapping("/settleOldestDue/{userId}")
	public ResponseEntity<String> settleMinDues(@PathVariable(name = "userId", required = true) long userId)
			throws NoSuchUserException {
		// check if user exists
		if (!userHandler.isUserExists(userId))
			throw new NoSuchUserException(userHandler.notFoundMessage(userId));

		// get oldest Due for the user
		Dues dues = duesHandler.getOldestDueForUser(userId);
		if (dues == null)
			ResponseEntity.ok("No Dues left for this user !");

		// delete dues
		duesHandler.deleteDues(dues);

		System.out.println("sucessfully deleted the dues :" + dues);
		return ResponseEntity.ok(String.format("Dues : {}  resolved successfully !", dues));

	}
}
