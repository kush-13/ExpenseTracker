package com.expense.tracker.Controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.DTO.ExpenseDTO;
import com.expense.tracker.Entity.Expense;
import com.expense.tracker.Exceptions.NoSuchUserException;
import com.expense.tracker.Service.ExpenseService;
import com.expense.tracker.Service.UserService;

@RestController
public class ExpenseController {
	@Autowired
	ExpenseService expenseHandler;
	@Autowired
	UserService userHandler;

	@PostMapping("/recordExpense")
	public ResponseEntity<String> recordExpense(@RequestBody @Valid ExpenseDTO expenseDTO) throws NoSuchUserException {

		// check if user exists in db
		if (!userHandler.isUserExists(expenseDTO.getUserId()))
			throw new NoSuchUserException(userHandler.notFoundMessage(expenseDTO.getUserId()));

		// record Expense
		expenseHandler.saveExpense(expenseDTO);

		return ResponseEntity.ok("Expense Recorded Sucessfully");
	}

	@GetMapping("/getExpenses/{userId}")
	public List<Expense> getExpenses(
			@PathVariable(name = "userId", required = true) @Valid @Min(value = 0, message = "userId can not be < 0 ") long userId)
			throws NoSuchUserException {
		// check if user exists
		if (!userHandler.isUserExists(userId))
			throw new NoSuchUserException(userHandler.notFoundMessage(userId));

		// get expenses for users
		return expenseHandler.getExpensesForUser(userId);
	}
}
