package com.expense.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.tracker.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
