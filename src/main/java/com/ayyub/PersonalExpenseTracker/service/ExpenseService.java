package com.ayyub.PersonalExpenseTracker.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ayyub.PersonalExpenseTracker.dto.ExpenseRequest;
import com.ayyub.PersonalExpenseTracker.entity.Category;
import com.ayyub.PersonalExpenseTracker.entity.Expense;
import com.ayyub.PersonalExpenseTracker.entity.User;
import com.ayyub.PersonalExpenseTracker.exception.CategoryNotFoundException;
import com.ayyub.PersonalExpenseTracker.exception.ExpenseNotFoundException;
import com.ayyub.PersonalExpenseTracker.exception.UserNotFoundException;
import com.ayyub.PersonalExpenseTracker.repository.CategoryRepository;
import com.ayyub.PersonalExpenseTracker.repository.ExpenseRepository;
import com.ayyub.PersonalExpenseTracker.repository.UserRepository;
import com.ayyub.PersonalExpenseTracker.util.SecurityUtil;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final SecurityUtil securityUtil;

    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository,
                          CategoryRepository categoryRepository,
                          SecurityUtil securityUtil) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.securityUtil = securityUtil;
    }

    public Expense createExpense(ExpenseRequest request) {

        User user = securityUtil.getLoggedInUser();

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Expense expense = new Expense();

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());
        expense.setUser(user);
        expense.setCategory(category);

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
    	User user = securityUtil.getLoggedInUser();
        return expenseRepository.findByUser(user);
    }

    public Expense getExpenseById(Long id) {
    	User user = securityUtil.getLoggedInUser();
        return expenseRepository
        		.findByIdAndUser(id, user)
        		.orElseThrow(() -> new ExpenseNotFoundException("Expense Not Found"));
        
    }

    public Expense updateExpense(Long id, ExpenseRequest request) {

        User loggedInUser = securityUtil.getLoggedInUser();

        Expense expense = expenseRepository
                .findByIdAndUser(id, loggedInUser)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense Not Found"));

        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(category);
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());
        expense.setUser(loggedInUser);

        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {

    	User user = securityUtil.getLoggedInUser();
    	
    	Expense expense = expenseRepository
    			.findByIdAndUser(id, user)
    			.orElseThrow(() -> new ExpenseNotFoundException("Expense Not Found"));
    	
    	expenseRepository.delete(expense);
    }
    
    public Page<Expense> getExpenses(int page,
    		int size,
    		String sortBy,
    		String direction){
    	
    	User loggedInUser = securityUtil.getLoggedInUser();
    	
    	Sort sort = direction.equalsIgnoreCase("desc")
    			?Sort.by(sortBy).descending()
    					:Sort.by(sortBy).ascending();
    	
    	Pageable pageable = PageRequest.of(page, size, sort);
    	
    	return expenseRepository.findByUser(loggedInUser, pageable);
    }
    
    public Page<Expense> searchExpense(String keyword,
            int page,
            int size) {

User loggedInUser = securityUtil.getLoggedInUser();

Pageable pageable = PageRequest.of(page, size);

return expenseRepository.findByUserAndTitleContainingIgnoreCase(
loggedInUser,
keyword,
pageable);
}
    
    public Page<Expense> getExpenseByCategory(Long categoryId,
    		int page,
    		int size){
    	
    	User loggedInUser = securityUtil.getLoggedInUser();
    	
    	Pageable pageable = PageRequest.of(page, size);
    	
    	return expenseRepository.findByUserAndCategoryId(loggedInUser, categoryId, pageable);
    }
}