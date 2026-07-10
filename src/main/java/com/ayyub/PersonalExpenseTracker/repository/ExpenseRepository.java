package com.ayyub.PersonalExpenseTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ayyub.PersonalExpenseTracker.entity.User;
import com.ayyub.PersonalExpenseTracker.entity.Expense;


public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	List<Expense> findByUser(User user);
	
	Optional<Expense> findByIdAndUser(Long id, User user);
}
