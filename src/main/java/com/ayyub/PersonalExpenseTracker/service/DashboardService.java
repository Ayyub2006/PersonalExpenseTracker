package com.ayyub.PersonalExpenseTracker.service;

import java.time.YearMonth;

import org.springframework.stereotype.Service;

import com.ayyub.PersonalExpenseTracker.dto.DashboardResponse;
import com.ayyub.PersonalExpenseTracker.entity.Budget;
import com.ayyub.PersonalExpenseTracker.entity.User;
import com.ayyub.PersonalExpenseTracker.repository.BudgetRepository;
import com.ayyub.PersonalExpenseTracker.repository.CategoryRepository;
import com.ayyub.PersonalExpenseTracker.repository.ExpenseRepository;
import com.ayyub.PersonalExpenseTracker.repository.IncomeRepository;
import com.ayyub.PersonalExpenseTracker.util.SecurityUtil;

@Service
public class DashboardService {

    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;
    private final CategoryRepository categoryRepository;
    private final BudgetRepository budgetRepository;
    private final SecurityUtil securityUtil;

    public DashboardService(
            ExpenseRepository expenseRepository,
            IncomeRepository incomeRepository,
            CategoryRepository categoryRepository,
            BudgetRepository budgetRepository,
            SecurityUtil securityUtil) {

        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
        this.categoryRepository = categoryRepository;
        this.budgetRepository = budgetRepository;
        this.securityUtil = securityUtil;
    }

    public DashboardResponse getDashboardSummary() {

        User loggedInUser = securityUtil.getLoggedInUser();

        Double totalIncome = incomeRepository.getTotalIncomeByUser(loggedInUser);
        Double totalExpense = expenseRepository.getTotalExpenseByUser(loggedInUser);

        // Null values handle karo
        if (totalIncome == null) totalIncome = 0.0;
        if (totalExpense == null) totalExpense = 0.0;

        Long totalIncomeEntries = incomeRepository.countByUser(loggedInUser);
        Long totalExpenseEntries = expenseRepository.countByUser(loggedInUser);
        Long totalCategories = categoryRepository.countByUser(loggedInUser);

        Double remainingBalance = totalIncome - totalExpense;

        // Budget Logic
        Budget budget = budgetRepository
                .findByUserAndMonth(loggedInUser, YearMonth.now())
                .orElse(null);

        Double monthlyBudget = 0.0;
        Double remainingBudget = 0.0;
        Boolean budgetExceeded = false;

        if (budget != null) {
            monthlyBudget = budget.getAmount();
            remainingBudget = monthlyBudget - totalExpense;
            budgetExceeded = totalExpense > monthlyBudget;
        }

        return DashboardResponse.builder()
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .remainingBalance(remainingBalance)
                .totalIncomeEntries(totalIncomeEntries)
                .totalExpenseEntries(totalExpenseEntries)
                .totalCategories(totalCategories)

                // Budget Fields
                .monthlyBudget(monthlyBudget)
                .remainingBudget(remainingBudget)
                .budgetExceeded(budgetExceeded)

                .build();
    }
}