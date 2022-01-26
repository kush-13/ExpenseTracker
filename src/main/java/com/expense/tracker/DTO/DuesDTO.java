package com.expense.tracker.DTO;

import java.time.LocalDate;

import javax.persistence.Transient;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.expense.tracker.Entity.Dues;

public class DuesDTO {
	private Long dueId;
	@NotNull
	private Long userId;
	@NotNull
	private Long owedUserId;
	@NotNull
	@Min(value = 0, message = "due amount can not be negative !")
	private Long dueAmount;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd", iso = ISO.DATE)
	private LocalDate repaymentDate;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd", iso = ISO.DATE)
	private LocalDate creationDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOwedUserId() {
		return owedUserId;
	}

	public void setOwedUserId(Long owedUserId) {
		this.owedUserId = owedUserId;
	}

	public Long getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Long dueAmount) {
		this.dueAmount = dueAmount;
	}

	public LocalDate getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(LocalDate repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Long getDueId() {
		return dueId;
	}

	public Dues getEntity() {
		Dues dues = new Dues();
		dues.setAmountDue(dueAmount);
		dues.setCreationDate(creationDate);
		dues.setOwedUserId(owedUserId);
		dues.setRepaymentDate(repaymentDate);
		dues.setUserId(userId);
		return dues;
	}

}
