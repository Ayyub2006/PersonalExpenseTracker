package com.ayyub.PersonalExpenseTracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ayyub.PersonalExpenseTracker.dto.BudgetRequest;
import com.ayyub.PersonalExpenseTracker.entity.Budget;
import com.ayyub.PersonalExpenseTracker.service.BudgetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public ResponseEntity<Budget> setBudget(
            @Valid @RequestBody BudgetRequest request) {

        return ResponseEntity.ok(
                budgetService.setBudget(request));
    }

    @GetMapping("/current")
    public ResponseEntity<Budget> getCurrentMonthBudget() {

        Budget budget = budgetService.getCurrentMonthBudget();

        if (budget == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(budget);
    }
}
