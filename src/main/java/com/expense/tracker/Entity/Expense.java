package com.expense.tracker.Entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.expense.tracker.ModeOfExpense;

@Entity
public class Expense {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long expendseId;
	@NotNull
	private Long userId;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd", iso = ISO.DATE)
	private LocalDate expenseDate;
	private String reason;
	@Column(nullable = false)
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
		return expendseId;
	}

	@Override
	public String toString() {
		return "Expense [expendseId=" + expendseId + ", userId=" + userId + ", expenseDate=" + expenseDate + ", reason="
				+ reason + ", expenseMode=" + expenseMode + ", comments=" + comments + "]";
	}

}
