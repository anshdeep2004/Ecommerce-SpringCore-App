# EcommerceSpringCore

This project is a simple Spring Core ecommerce application that connects to a MySQL database using Spring JDBC. It demonstrates how to build a small database-driven application with dependency injection, repositories, services, and Java-based configuration.

## Three main tasks completed

1. Insert a product with related category and vendor
   - Created the core domain models for Category, Product, and Vendor.
   - Used the repository-service pattern to save a new product.
   - Linked the product to existing category and vendor records through foreign key values.

2. Retrieve a product with joined data
   - Wrote a SQL query that joins the product, category, and vendor tables.
   - Used RowMapper with Spring JdbcTemplate to map the result into a full Product object.
   - This allows the app to return product details along with the category name and vendor name.

3. Update stock and view vendor product counts
   - Implemented an update query to change the stock quantity of a product.
   - Added a grouped SQL query to count how many products each vendor has.
   - The result is returned through Spring JDBC and displayed in the application.

## How the project is structured

- AppConfig sets up the database connection and JdbcTemplate.
- Services contain the business logic.
- Repositories handle the SQL operations.
- App.java runs the demo flow for the tasks above.

## Run the project

1. Configure your MySQL database details in application.properties.
2. Run the project with your Java IDE or Maven.
3. Execute the main class in App.java to see the demo output.
