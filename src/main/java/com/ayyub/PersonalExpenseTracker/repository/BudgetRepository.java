package com.ayyub.PersonalExpenseTracker.repository;

import java.time.YearMonth;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayyub.PersonalExpenseTracker.entity.Budget;
import com.ayyub.PersonalExpenseTracker.entity.User;

public interface BudgetRepository extends JpaRepository<Budget, Long>{

	Optional<Budget> findByUserAndMonth(User user, YearMonth month);
}
