package com.ecomspring.utility;

import com.ecomspring.model.Category;
import com.ecomspring.model.Product;
import com.ecomspring.model.Vendor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductUtility implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category(
                rs.getInt("category_id"),
                rs.getString("cat_name"),
                rs.getString("cat_description")
        );
        Vendor vendor = new Vendor(
                rs.getInt("vendor_id"),
                rs.getString("vendor_name"),
                rs.getString("email")
        );
        Product product = new Product(
                rs.getInt("product_id"),
                rs.getDouble("price"),
                rs.getString("prod_name"),
                rs.getInt("stockQuantity"),
                category,
                vendor
        );

        return product;
    }
}
