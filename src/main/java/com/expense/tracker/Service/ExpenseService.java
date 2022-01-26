package com.expense.tracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.tracker.DTO.ExpenseDTO;
import com.expense.tracker.Entity.Expense;
import com.expense.tracker.Repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	public Expense saveExpense(ExpenseDTO expenseDTO) {
		return expenseRepository.save(expenseDTO.getEntity());
	}

	public List<Expense> getExpensesForUser(long userId) {
		return expenseRepository.findAllByUserId(userId);
	}

}
