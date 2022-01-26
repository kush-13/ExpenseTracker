package com.expense.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.tracker.Entity.Dues;

public interface DuesRepository extends JpaRepository<Dues, Long>{

	Dues findTopByUserIdOrderByCreationDateAsc(long userId);
	
	Dues findTopByUserIdOrderByRepaymentDateAsc(long userId);

}
