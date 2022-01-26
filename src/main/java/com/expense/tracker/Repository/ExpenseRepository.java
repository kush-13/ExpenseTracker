package com.expense.tracker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.tracker.Entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	List<Expense> findAllByUserId(long userId);

}
