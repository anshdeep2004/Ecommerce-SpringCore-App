package com.ecomspring;

import com.ecomspring.model.Category;
import com.ecomspring.model.Product;
import com.ecomspring.model.Vendor;
import com.ecomspring.service.CategoryService;
import com.ecomspring.service.ProductService;
import com.ecomspring.service.VendorService;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class App {
    public static void main(String [] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean(ProductService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);
        VendorService vendorService = context.getBean(VendorService.class);
        /*
        Task 1 — Insert Product with FK references
        Implement save(Product product) in ProductRepository, inserting category_id and
        vendor_id correctly.
         */
        try {
            int categoryId = 1;
            Category category = categoryService.getCategoryById(categoryId);
            int vendorId = 3;
            Vendor vendor = vendorService.getVendorById(vendorId);
            Product product = new Product("Tractor", 1100, 45, category, vendor);
            productService.insert(product);
            System.out.println("Inserted successfully..");
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        /*
        Task 2 — Find Product by ID with joined data
        Implement findById(Long id) returning a Product (or DTO) that includes the category
        name and vendor name — using a JOIN query and a RowMapper.

         */
        try {
            int productId = 11;
            Product product = productService.getProductById(productId);
            System.out.println(product);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        /*
        Task 3 — Update stock quantity
        Implement updateStock(Long productId, int newQuantity) as a targeted UPDATE.
         */
        try {
            int productId = 5;
            int newStockQuantity = 10;
            Product product = productService.getProductById(productId);
            System.out.println("Current Product:");
            System.out.println(product);
            productService.update(productId, newStockQuantity);
            Product productUpdated = productService.getProductById(productId);
            System.out.println("Updated Product:");
            System.out.println(productUpdated);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        /*
        Task 4 — Aggregate query
        Implement countProductsByVendor() returning a Map<String, Integer> (vendor name
        → product count) using JdbcTemplate.query with a GROUP BY + JOIN, and a RowMapper  to
        build the map.
         */
        Map<String, Integer> vendorProdCount = productService.countProductsByVendor();
        vendorProdCount.forEach((vendorName, prod_count) -> {
            System.out.println(vendorName + " ---> " + prod_count);
        });

        context.close();
    }
}
