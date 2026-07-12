package com.ecomspring.repository;

import com.ecomspring.model.Category;
import com.ecomspring.utility.CategoryUtility;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CategoryUtility categoryUtility;

    public CategoryRepository(JdbcTemplate jdbcTemplate, CategoryUtility categoryUtility) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoryUtility = categoryUtility;
    }

    public Optional<Category> getCategoryById(int categoryId) {
        String sql = "Select * from category where id=?";
        return jdbcTemplate.query(sql, categoryUtility, categoryId).stream().findFirst();
    }
}
