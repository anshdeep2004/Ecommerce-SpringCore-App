package com.ecomspring.repository;

import com.ecomspring.model.Product;
import com.ecomspring.utility.ProductUtility;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProductUtility productUtility;

    public ProductRepository(JdbcTemplate jdbcTemplate, ProductUtility productUtility) {
        this.jdbcTemplate = jdbcTemplate;
        this.productUtility = productUtility;
    }

    public void insert(Product product) {
        String sql = "Insert into product(name, price, stockQuantity, category_id, vendor_id) values(?, ?, ?, ?, ?)";
        Object[] values = new Object[]{product.getName(), product.getPrice(), product.getStockQuantity(), product.getCategory().getId(), product.getVendor().getId()};
        jdbcTemplate.update(sql, values);
    }

    public Optional<Product> getProductById(int productId) {
        String sql = """
                    Select p.id as product_id, p.name as prod_name,
                    p.price, p.stockQuantity,
                    c.id as category_id, c.name as cat_name,
                    c.description as cat_description,
                    v.id as vendor_id, v.name as vendor_name,
                    v.email
                    from product p
                    Join category c
                    on p.category_id = c.id
                    Join vendor v
                    on p.vendor_id = v.id
                    where p.id = ?;
                """;
        return jdbcTemplate.query(sql, productUtility, productId).stream().findFirst();
    }

    public void update(int productId, int newStockQuantity) {
        String sql = "Update product set stockQuantity = ? where id = ?";
        Object[] values = new Object[]{newStockQuantity, productId};
        jdbcTemplate.update(sql, values);
    }

    public Map<String, Integer> countProductsByVendor() {
        String sql = "select v.name as vendor_name, Count(*) as prod_count from product p join vendor v on p.vendor_id = v.id group by v.name";
        Map<String, Integer> vendorProdCount = new HashMap<>();
        jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            vendorProdCount.put(rs.getString("vendor_name"), rs.getInt("prod_count"));
            return null;
        });

        return vendorProdCount;
    }
}
