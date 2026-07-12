package com.ecomspring.service;

import com.ecomspring.model.Category;
import com.ecomspring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryById(int categoryId) {
        return categoryRepository.getCategoryById(categoryId).
                orElseThrow(() -> new RuntimeException("Category id " + categoryId + " not found.."));
    }
}
