package com.expense.tracker.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Dues {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dueId;
	@Column(nullable = false)
	private Long userId;
	@Column(nullable = false)
	private Long amountDue;
	@DateTimeFormat(pattern = "yyyy-mm-dd", iso = ISO.DATE)
	private LocalDate repaymentDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd", iso = ISO.DATE)
	private LocalDate creationDate;
	@Column(nullable = false)
	private Long owedUserId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(Long amountDue) {
		this.amountDue = amountDue;
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

	public Long getOwedUserId() {
		return owedUserId;
	}

	public void setOwedUserId(Long owedUserId) {
		this.owedUserId = owedUserId;
	}

	public Long getDueId() {
		return dueId;
	}

	@Override
	public String toString() {
		return "Dues [dueId=" + dueId + ", userId=" + userId + ", amountDue=" + amountDue + ", repaymentDate="
				+ repaymentDate + ", creationDate=" + creationDate + ", owedUserId=" + owedUserId + "]";
	}

}
