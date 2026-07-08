package com.ayyub.PersonalExpenseTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayyub.PersonalExpenseTracker.dto.CategoryRequest;
import com.ayyub.PersonalExpenseTracker.entity.Category;
import com.ayyub.PersonalExpenseTracker.exception.CategoryAlreadyExistsException;
import com.ayyub.PersonalExpenseTracker.exception.CategoryNotFoundException;
import com.ayyub.PersonalExpenseTracker.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryRequest request) {

        if (categoryRepository.existsByName(request.getName())) {
            throw new CategoryAlreadyExistsException("Category already exists");
        }

        Category category = new Category();
        category.setName(request.getName());

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    public Category updateCategory(Long id, CategoryRequest request) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        category.setName(request.getName());

        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        categoryRepository.delete(category);
    }

}