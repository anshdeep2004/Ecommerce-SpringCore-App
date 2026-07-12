package com.ecomspring.utility;

import com.ecomspring.model.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryUtility implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
        return category;
    }
}
