package com.expense.tracker.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.expense.tracker.ModeOfExpense;
import com.expense.tracker.Entity.Expense;

@Component
public class ExpenseDTO {
	private Long expenseId;
	@NotNull
	private Long userId;
	@NotNull(message = "expense date is mandatory")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-mm-dd")
	private LocalDate expenseDate;
	private String reason;
	@NotNull(message = "mode of expense is mandatory")
	private ModeOfExpense expenseMode;
	private String comments;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ModeOfExpense getExpenseMode() {
		return expenseMode;
	}

	public void setExpenseMode(ModeOfExpense expenseMode) {
		this.expenseMode = expenseMode;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getExpendseId() {
		return expenseId;
	}

	public Expense getEntity() {
		Expense expense = new Expense();
		expense.setExpenseDate(expenseDate);
		expense.setExpenseMode(expenseMode);
		expense.setReason(reason);
		expense.setComments(comments);
		expense.setUserId(userId);	
		return expense;
	}

	@Override
	public String toString() {
		return "ExpenseDTO [expendseId=" + expenseId + ", userId=" + userId + ", expenseDate=" + expenseDate
				+ ", reason=" + reason + ", expenseMode=" + expenseMode + ", comments=" + comments + "]";
	}

}
