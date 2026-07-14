package com.ayyub.PersonalExpenseTracker.service;

import java.time.YearMonth;

import org.springframework.stereotype.Service;

import com.ayyub.PersonalExpenseTracker.dto.BudgetRequest;
import com.ayyub.PersonalExpenseTracker.entity.Budget;
import com.ayyub.PersonalExpenseTracker.entity.User;
import com.ayyub.PersonalExpenseTracker.repository.BudgetRepository;
import com.ayyub.PersonalExpenseTracker.util.SecurityUtil;

@Service
public class BudgetService {

	private final BudgetRepository budgetRepository;
	private final SecurityUtil securityUtil;
	
	public BudgetService(BudgetRepository budgetRepository,
			SecurityUtil securityUtil) {
		this.budgetRepository = budgetRepository;
		this.securityUtil = securityUtil;
	}
	
	public Budget setBudget(BudgetRequest request) {
		
		User loggedInUser = securityUtil.getLoggedInUser();
		Budget budget = budgetRepository.findByUserAndMonth(loggedInUser, request.getMonth())
				.orElse(Budget.builder()
	                    .user(loggedInUser)
	                    .month(request.getMonth())
	                    .build());

	    budget.setAmount(request.getAmount());

	    return budgetRepository.save(budget);
	}
	
	public Budget getCurrentMonthBudget() {

	    User loggedInUser = securityUtil.getLoggedInUser();

	    return budgetRepository
	            .findByUserAndMonth(loggedInUser, YearMonth.now())
	            .orElse(null);
	}
}
