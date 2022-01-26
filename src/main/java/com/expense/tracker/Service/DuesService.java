package com.expense.tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.tracker.DTO.DuesDTO;
import com.expense.tracker.Entity.Dues;
import com.expense.tracker.Repository.DuesRepository;

@Service
public class DuesService {

	@Autowired
	DuesRepository duesRepository;

	public Dues saveDues(DuesDTO duesDTO) {
		return duesRepository.save(duesDTO.getEntity());
	}

	public Dues getOldestDueForUser(long userId) {
		return duesRepository.findTopByUserIdOrderByCreationDateAsc(userId);
	}

	public void deleteDues(Dues dues) {
		duesRepository.delete(dues);

	}
	
	public Dues getEarliestRepaymentDuesForUser(long userId) {
		return duesRepository.findTopByUserIdOrderByRepaymentDateAsc(userId);
	}

}
